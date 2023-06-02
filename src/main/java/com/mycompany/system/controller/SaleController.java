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
import com.mycompany.system.util.JwtTokenUtil;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ro
 */
@RestController
@RequestMapping("/v1/sale")
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
    public ResponseEntity<List<Sale>> getAll(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody List<SaleDetail> saleDetail) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        Sale sale = saleDetail.get(0).getSale();

        //si pasa esta validacion inserta la venta, el detalle de la venta y la actualizacion en stock de la tienda
        validateStockStore(saleDetail);

        //inserta la venta y retorna la venta unsertada
        Sale saleSaved = service.saveAndReturnData(saleDetail.get(0).getSale());

        BigDecimal priceSale = new BigDecimal(BigInteger.ZERO);
        BigDecimal discountProductSale = new BigDecimal(BigInteger.ZERO);

        this.saveAndUpdateSalaDetails(saleDetail, saleSaved, priceSale, discountProductSale);

        saleSaved.setDiscount(discountProductSale.add(sale.getDiscount()));
        saleSaved.setPrice(priceSale);
        saleSaved.setTotalPrice(saleSaved.getPrice().subtract(saleSaved.getDiscount()));

        service.update(saleSaved);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PatchMapping
    public ResponseEntity<HttpStatus> update(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody List<SaleDetail> saleDetails) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        Sale sale = saleDetails.get(0).getSale();

        Optional<List<SaleDetail>> saleDetailsFromDB = saleDetailService.findBySaleId(sale.getId());

        //validate ids for sale details

        //end validate ids for sale details

        //validate stock
        for (SaleDetail newSaleDetail : saleDetails) {

            if (newSaleDetail.getId() == 0) {
                //call stock service
                Optional<StoreStock> stockProduct = storeStockService.findByProductIdAndStoreId(newSaleDetail.getProduct().getId(), newSaleDetail.getSale().getStore().getId());
                if (!stockProduct.isPresent()) {
                    //not product registry in stock
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                if (newSaleDetail.getQuantity() > stockProduct.get().getQuantity()) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else if (newSaleDetail.getId() != 0) {

                //if (newSaleDetail.getCancelSaleDetail() == 1) only return product to stock
                if (newSaleDetail.getCancelSaleDetail() == 0){
                    Optional<StoreStock> stockProduct = storeStockService.findByProductIdAndStoreId(newSaleDetail.getProduct().getId(), newSaleDetail.getSale().getStore().getId());
                    if (!stockProduct.isPresent()) {
                        //not product registry in stock
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                    }

                    for (SaleDetail detailDB : saleDetailsFromDB.get()) {
                        if (detailDB.getId() == newSaleDetail.getId()) {
                            int quantityAll = stockProduct.get().getQuantity() + detailDB.getQuantity();
                            if (newSaleDetail.getQuantity() > quantityAll) {
                                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                            }
                        }
                    }
                }
            }
        }
        //end validate stock

        //update sale detail and stock
        for (SaleDetail newSaleDetail : saleDetails) {

            if (newSaleDetail.getId() == 0) {
                //call stock service
                Optional<StoreStock> stockProduct = storeStockService.findByProductIdAndStoreId(newSaleDetail.getProduct().getId(), newSaleDetail.getSale().getStore().getId());
                if (!stockProduct.isPresent()) {
                    //not product registry in stock
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                if (newSaleDetail.getQuantity() > stockProduct.get().getQuantity()) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }

                saleDetailService.save(newSaleDetail);
                storeStockService.update(builStock(stockProduct, 0, newSaleDetail));


            } else if (newSaleDetail.getId() != 0) {

                //if (newSaleDetail.getCancelSaleDetail() == 1) only return product to stock
                if (newSaleDetail.getCancelSaleDetail() == 0){
                    Optional<StoreStock> stockProduct = storeStockService.findByProductIdAndStoreId(newSaleDetail.getProduct().getId(), newSaleDetail.getSale().getStore().getId());
                    if (!stockProduct.isPresent()) {
                        //not product registry in stock
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                    }

                    for (SaleDetail detailDB : saleDetailsFromDB.get()) {
                        if (detailDB.getId() == newSaleDetail.getId()) {
                            int quantityAll = stockProduct.get().getQuantity() + detailDB.getQuantity();
                            if (newSaleDetail.getQuantity() > quantityAll) {
                                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                            }
                            saleDetailService.update(newSaleDetail);
                            storeStockService.update(builStock(stockProduct, detailDB.getQuantity(), newSaleDetail));
                        }
                    }
                }
            }
        }
        //end update sale detail and stock

        BigDecimal priceSale = new BigDecimal(BigInteger.ZERO);
        BigDecimal discountProductSale = new BigDecimal(BigInteger.ZERO);

        Optional<List<SaleDetail>> saleDetailsFromDBAfterUpdate = saleDetailService.findBySaleId(sale.getId());

        for (SaleDetail saleDetailAfter : saleDetailsFromDBAfterUpdate.get()){
            priceSale.add(saleDetailAfter.getTotalPrice());
            discountProductSale = discountProductSale.add(saleDetailAfter.getDiscount());
        }

        sale.setDiscount(discountProductSale.add(sale.getDiscount()));
        sale.setPrice(priceSale);
        sale.setTotalPrice(sale.getPrice().subtract(sale.getDiscount()));

        service.update(sale);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable int id) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private void saveAndUpdateSalaDetails(List<SaleDetail> saleDetail, Sale saleSaved, BigDecimal priceSale, BigDecimal discountProductSale) {

        for (SaleDetail detail : saleDetail) {

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
            discount = (discount == null || discount == BigDecimal.ZERO) ? BigDecimal.ZERO : detail.getDiscount();

            BigDecimal allPriceProduct = optional.get().getPrice().multiply(BigDecimal.valueOf(detail.getQuantity()));

            detail.setTotalPrice(allPriceProduct.subtract(discount));

            //precios para la venta
            discountProductSale = discountProductSale.add(discount);
            priceSale = priceSale.add(allPriceProduct);

            saleDetailService.save(detail);
            storeStockService.update(builStock(storeStockOpt, 0, detail));

        }
    }

    private void validateStockStore(List<SaleDetail> saleDetail) throws IllegalArgumentException {
        for (SaleDetail detail : saleDetail) {

            int idProduct = detail.getProduct().getId();
            int idStore = detail.getSale().getStore().getId();

            Optional<StoreStock> storeStockOpt = storeStockService.findByProductIdAndStoreId(idProduct, idStore);

            if (!storeStockOpt.isPresent()) {

                throw new IllegalArgumentException("El producto " + detail.getProduct().getName() + " no esxite en stock de la tienda");
            }

            if (detail.getQuantity() > storeStockOpt.get().getQuantity()) {

                throw new IllegalArgumentException("El stock del producto " + detail.getProduct().getName() + " es menor al pedido del cliente");

            }
        }
    }

    private StoreStock builStock(Optional<StoreStock> storeStockOptFronDB, int quantityVentaFromDB, SaleDetail saleDetail) {

        StoreStock storeStockDB = storeStockOptFronDB.get();

        //for create new sale
        if (quantityVentaFromDB == 0){
            int newQuantity = storeStockDB.getQuantity() - saleDetail.getQuantity();

            return StoreStock.builder()
                    .id(storeStockDB.getId())
                    .product(storeStockDB.getProduct())
                    .store(storeStockDB.getStore())
                    .quantity(newQuantity)
                    .build();
        }

        //for update sale
        int newQuantity = (storeStockDB.getQuantity() +  quantityVentaFromDB)- saleDetail.getQuantity();

        return StoreStock.builder()
                .id(storeStockDB.getId())
                .product(storeStockDB.getProduct())
                .store(storeStockDB.getStore())
                .quantity(newQuantity)
                .build();

        }
}
