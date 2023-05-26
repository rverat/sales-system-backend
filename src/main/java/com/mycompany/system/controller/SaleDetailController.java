/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.controller;

import com.mycompany.system.model.business.SaleDetail;
import com.mycompany.system.service.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author ro
 */
@RestController
@RequestMapping("/sale-detail")
public class SaleDetailController {

    @Autowired
    private SaleDetailService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<SaleDetail>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(path="/{saleId}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<SaleDetail>> getSaleDetails(@PathVariable int saleId) {

        Optional<List<SaleDetail>> saleDetails = service.findBySaleId(saleId);

        if(!saleDetails.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(saleDetails.get(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody SaleDetail saleDetail) {
        service.save(saleDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PostMapping("/save-all")
    public ResponseEntity<HttpStatus> createMany(@RequestBody List<SaleDetail> saleDetails) {
        service.saveAll(saleDetails);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<HttpStatus> update(@RequestBody SaleDetail saleDetail) {
        service.update(saleDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id_sale}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
