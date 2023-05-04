/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.controller;

import com.mycompany.system.model.business.Product;
import com.mycompany.system.model.business.ProductOutStore;
import com.mycompany.system.model.business.Store;
import com.mycompany.system.model.business.StoreStock;
import com.mycompany.system.model.business.WarehouseStock;
import com.mycompany.system.service.ProductOutStoreService;
import com.mycompany.system.service.StoreStockService;
import com.mycompany.system.service.WarehouseStockService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ro
 */
@RestController
@RequestMapping("/product-out-store")
public class ProductOutStoreController {

    @Autowired
    private ProductOutStoreService service;

    @Autowired
    private StoreStockService storeStockService;

    @Autowired
    private WarehouseStockService warehouseStockService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<ProductOutStore>> getAll() {

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody ProductOutStore productOutStore) {

        Product product = productOutStore.getProduct();
        Store store = productOutStore.getStore();

        Optional<WarehouseStock> warehouseStockOpt = warehouseStockService.findByProductId(productOutStore.getProduct().getId());
        Optional<StoreStock> storeStock = storeStockService.findByProductIdAndStoreId(product.getId(), store.getId());

        if (existStockAvailable(warehouseStockOpt, productOutStore.getQuantity())) {

            service.save(productOutStore);

            storeStockService.save(builStock(storeStock, 0, productOutStore));

            Optional<ProductOutStore> productOutStoreOpt = service.findById(productOutStore.getId());

            warehouseStockService.update(builStockWWhenSave(warehouseStockOpt, productOutStoreOpt, productOutStore));

            return new ResponseEntity<>(HttpStatus.CREATED);

        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PatchMapping
    public ResponseEntity<HttpStatus> update(@RequestBody ProductOutStore productOutStore) {

        Product product = productOutStore.getProduct();
        Store store = productOutStore.getStore();

        Optional<WarehouseStock> warehouseStockOpt = warehouseStockService.findByProductId(productOutStore.getProduct().getId());
        Optional<StoreStock> storeStock = storeStockService.findByProductIdAndStoreId(product.getId(), store.getId());

        Optional<ProductOutStore> productOutStoreOpt = service.findById(productOutStore.getId());

        if (productOutStoreOpt.isPresent()) {
            if (existStockAvailable(warehouseStockOpt, productOutStore.getQuantity())) {

                service.save(productOutStore);

                storeStockService.update(builStock(storeStock, productOutStoreOpt.get().getQuantity(), productOutStore));

                warehouseStockService.update(builStockWWhenSave(warehouseStockOpt, productOutStoreOpt, productOutStore));

                return new ResponseEntity<>(HttpStatus.CREATED);

            }
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {

        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private StoreStock builStock(Optional<StoreStock> storeStockOpt, int quantityFromDB, ProductOutStore productOutStore) {

        if (!storeStockOpt.isPresent()) {
            
            //StoreStock storeStock= storeStockOpt.get();
            
            return StoreStock.builder()
                    .id(0)
                    .product(productOutStore.getProduct())
                    .store(productOutStore.getStore())
                    .quantity(productOutStore.getQuantity())
                    .build();
        }

        StoreStock storeStock = storeStockOpt.get();

        int newQuantity = storeStock.getQuantity() - quantityFromDB + productOutStore.getQuantity();

        return StoreStock.builder()
                .id(storeStock.getId())
                .product(storeStock.getProduct())
                .store(storeStock.getStore())
                .quantity(newQuantity)
                .build();
    }

    private WarehouseStock builStockWWhenSave(Optional<WarehouseStock> warehouseStockOpt, Optional<ProductOutStore> productOutStoreOpt, ProductOutStore productOutStore) {

        Product product = productOutStore.getProduct();

        //actializa stock en iventario
        WarehouseStock warehouseStock = warehouseStockOpt.get();

        int newQuantity;

        if (productOutStoreOpt.isPresent()) {

            newQuantity = warehouseStock.getQuantity() + productOutStoreOpt.get().getQuantity() - productOutStore.getQuantity();

        } else {
            newQuantity = warehouseStock.getQuantity() - productOutStore.getQuantity();
        }

        return WarehouseStock.builder()
                .id(warehouseStock.getId())
                .product(product)
                .quantity(newQuantity)
                .build();
    }

    private boolean existStockAvailable(Optional<WarehouseStock> warehouseStockOpt, int quantity) {

        if (!warehouseStockOpt.isPresent()) {
            // retorna error porque no se registro la entrada de dicho producto
            return false;
        }

        if (warehouseStockOpt.get().getQuantity() <= quantity) {
            // no se puede ejecutar la operacion de envio a tienda porque no hay producto en stock de alamcen
            return false;
        }

        //ahora insertar o modificar envio a tienda y actualizar stock en almacen y tienda
        return true;

    }
}
