/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.controller;

import com.mycompany.system.model.business.StoreStock;
import com.mycompany.system.service.StoreStockService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ro
 */
@RestController
@RequestMapping("/store-stock")
public class StoreStockController {

    @Autowired
    private StoreStockService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<StoreStock>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    
     
    @PostMapping("/stock")
    public ResponseEntity<StoreStock> findByProductIdAndStoreId(
            @RequestParam(name= "productId") int productId, @RequestParam(name= "storeId") int storeId){
        
        Optional<StoreStock> optional = service.findByProductIdAndStoreId(productId, storeId);
        
        if(optional.isPresent()){
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        
    }


    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody StoreStock storeStock) {
        service.save(storeStock);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<HttpStatus> update(@RequestBody StoreStock storeStock) {
        service.update(storeStock);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
