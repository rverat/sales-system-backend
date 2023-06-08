/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.controller;

import com.mycompany.system.model.business.SaleDetail;
import com.mycompany.system.service.SaleDetailService;
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
@RequestMapping("/v1/sale-detail")
public class SaleDetailController {

    @Autowired
    private SaleDetailService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<SaleDetail>> getAll(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{saleId}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<SaleDetail>> getSaleDetails(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable int saleId) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        Optional<List<SaleDetail>> saleDetails = service.findBySaleId(saleId);

        if (!saleDetails.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(saleDetails.get(), HttpStatus.OK);

    }

    @GetMapping(path = "/{saleDetailId}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<SaleDetail> getSaleDetail(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable int saleDetailId) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        Optional<SaleDetail> saleDetail = service.findBySaleDetailId(saleDetailId);

        if (!saleDetail.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(saleDetail.get(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody SaleDetail saleDetail) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        service.save(saleDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/save-all")
    public ResponseEntity<HttpStatus> createMany(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody List<SaleDetail> saleDetails) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        service.saveAll(saleDetails);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<HttpStatus> update(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody SaleDetail saleDetail) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        service.update(saleDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id_sale}")
    public ResponseEntity<HttpStatus> delete(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable int id) throws ParseException, JOSEException {

        ResponseEntity HTTP_EXCEPTION = JwtTokenUtil.validateToken(token);
        if (HTTP_EXCEPTION != null) return HTTP_EXCEPTION;

        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
