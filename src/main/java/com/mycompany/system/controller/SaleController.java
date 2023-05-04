/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.controller;

import com.mycompany.system.model.business.Product;
import com.mycompany.system.model.business.Sale;
import com.mycompany.system.model.business.SaleDetail;
import com.mycompany.system.model.business.StoreStock;
import com.mycompany.system.service.ProductService;
import com.mycompany.system.service.SaleDetailService;
import com.mycompany.system.service.SaleService;
import com.mycompany.system.service.StoreStockService;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService service;

    @Autowired
    private StoreStockService storeStockService;

    @Autowired
    private SaleDetailService saleDetailService;

    @Autowired
    private ProductService productService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<Sale>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody List<SaleDetail> saleDetail) {

        validateStockStore(saleDetail);
        
        //si pasa las validaciones anteriores inserta la venta y detalle y la actualizacion en stock

        Sale saleSaved = service.saveAndReturnData(saleDetail.get(0).getSale());

        BigDecimal priceSale = new BigDecimal(BigInteger.ZERO);
        BigDecimal discountSale = new BigDecimal(BigInteger.ZERO);
        
        BigDecimal descountAllProduct = new BigDecimal(BigInteger.ZERO);
        

        for (SaleDetail detail : saleDetail) {

            descountAllProduct = detail.getSale().getDiscount();

            int idProduct = detail.getProduct().getId();
            int idStore = detail.getSale().getStore().getId();

            Optional<StoreStock> storeStockOpt = storeStockService.findByProductIdAndStoreId(idProduct, idStore);
            Optional<Product> optional = productService.findById(detail.getProduct().getId());

            if (!storeStockOpt.isPresent()) {
                throw new IllegalArgumentException("El producto " + detail.getProduct().getName() + " no esxite en stock de la tienda");
            }

            if (storeStockOpt.get().getQuantity() <= detail.getQuantity()) {
                throw new IllegalArgumentException("El stock del producto " + detail.getProduct().getName() + " es menor al pedido del cliente");

            }

            detail.setSale(saleSaved);
            detail.setUnitPrice(optional.get().getPrice());

            BigDecimal discount = detail.getDiscount();
            discount = (discount == null || discount ==  BigDecimal.ZERO) ? BigDecimal.ZERO : detail.getDiscount();
            
            BigDecimal allPriceProduct = optional.get().getPrice().multiply(BigDecimal.valueOf(detail.getQuantity()));

            detail.setTotalPrice(allPriceProduct.subtract(discount));
            

            //precios para la venta
            discountSale = discountSale.add(discount);            
            priceSale = priceSale.add(allPriceProduct);

            saleDetailService.save(detail);
            storeStockService.update(builStock(storeStockOpt, 0, detail));

        }

            
        saleSaved.setDiscount(discountSale.add(descountAllProduct));        
        saleSaved.setPrice(priceSale);        
        saleSaved.setTotalPrice(saleSaved.getPrice().subtract(descountAllProduct).subtract(discountSale));

        service.update(saleSaved);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    
    @PatchMapping
    public ResponseEntity<HttpStatus> update(@RequestBody Sale sale) {
        service.update(sale);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private void validateStockStore(List<SaleDetail> saleDetail) throws IllegalArgumentException {
        for (SaleDetail detail : saleDetail) {
            
            int idProduct = detail.getProduct().getId();
            int idStore = detail.getSale().getStore().getId();
            
            Optional<StoreStock> storeStockOpt = storeStockService.findByProductIdAndStoreId(idProduct, idStore);
            
            if (!storeStockOpt.isPresent()) {
                
                throw new IllegalArgumentException("El producto " + detail.getProduct().getName() + " no esxite en stock de la tienda");
            }
            
            if (storeStockOpt.get().getQuantity() <= detail.getQuantity()) {
                
                throw new IllegalArgumentException("El stock del producto " + detail.getProduct().getName() + " es menor al pedido del cliente");
                
            }
            
        }
    }

    private StoreStock builStock(Optional<StoreStock> storeStockOptFronDB, int quantityVentaFromDB, SaleDetail saleDetail) {

        StoreStock storeStockDB = storeStockOptFronDB.get();

        int newQuantity = storeStockDB.getQuantity() - saleDetail.getQuantity();

        return StoreStock.builder()
                .id(storeStockDB.getId())
                .product(storeStockDB.getProduct())
                .store(storeStockDB.getStore())
                .quantity(newQuantity)
                .build();
    }

}
