/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.controller;

import com.mycompany.system.model.business.StoreStock;
import com.mycompany.system.service.StoreStockService;
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
@RequestMapping("/v1/store-stock")
public class StoreStockController {

    @Autowired
    private StoreStockService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<StoreStock>> getAll(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @PostMapping("/stock")
    public ResponseEntity<StoreStock> findByProductIdAndStoreId(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                @RequestParam(name = "productId") int productId,
                                                                @RequestParam(name = "storeId") int storeId) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        Optional<StoreStock> optional = service.findByProductIdAndStoreId(productId, storeId);

        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody StoreStock storeStock) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        service.save(storeStock);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<HttpStatus> update(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody StoreStock storeStock) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        service.update(storeStock);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable int id) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
