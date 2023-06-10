/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.controller;

import com.mycompany.system.model.business.WarehouseStock;
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

/**
 * @author ro
 */
@RestController
@RequestMapping("/v1/warehouse-stock")
public class WarehouseStockController {

    @Autowired
    private WarehouseStockService warehouseStockService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<WarehouseStock>> getAll(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        return new ResponseEntity<>(warehouseStockService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WarehouseStock> save(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody WarehouseStock warehouseStock) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        warehouseStockService.save(warehouseStock);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<WarehouseStock> update(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody WarehouseStock warehouseStock) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        warehouseStockService.update(warehouseStock);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WarehouseStock> delete(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable int id) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        warehouseStockService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
