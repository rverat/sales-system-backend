/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.controller;

import com.mycompany.system.model.business.Product;
import com.mycompany.system.model.business.ProductEntryWarehouse;
import com.mycompany.system.model.business.WarehouseStock;
import com.mycompany.system.service.ProductEntryWarehouseService;
import com.mycompany.system.service.WarehouseStockService;
import com.mycompany.system.util.JwtTokenUtil;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * @author ro
 */
@RestController
@RequestMapping("/v1/product-entry-warehouse")
public class ProductEntryWarehouseController {

    @Autowired
    private ProductEntryWarehouseService service;

    @Autowired
    private WarehouseStockService WService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<ProductEntryWarehouse>> getAll(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody ProductEntryWarehouse productEntryWarehouse) {

        service.save(productEntryWarehouse);
        WService.save(builStock(productEntryWarehouse, 0));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<HttpStatus> update(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody ProductEntryWarehouse productEntryWarehouse) {

        Optional<ProductEntryWarehouse> optional = service.findById(productEntryWarehouse.getId());

        if (optional.isPresent()) {
            service.update(productEntryWarehouse);

            ProductEntryWarehouse entryWarehouseFromDB = optional.get();
            WService.update(builStock(productEntryWarehouse, entryWarehouseFromDB.getQuantity()));
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable int id) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private WarehouseStock builStock(ProductEntryWarehouse productEntryWarehouse, int quantityFromDB) {

        Product product = productEntryWarehouse.getProduct();
        Optional<WarehouseStock> warehouseStockOpt = WService.findByProductId(product.getId());

        if (!warehouseStockOpt.isPresent()) {
            return WarehouseStock.builder()
                    .id(0)
                    .product(product)
                    .quantity(productEntryWarehouse.getQuantity())
                    .build();
        }

        WarehouseStock warehouseStock = warehouseStockOpt.get();
        int newQuantity = warehouseStock.getQuantity() - quantityFromDB + productEntryWarehouse.getQuantity();

        return WarehouseStock.builder()
                .id(warehouseStock.getId())
                .product(product)
                .quantity(newQuantity)
                .build();
    }

}
