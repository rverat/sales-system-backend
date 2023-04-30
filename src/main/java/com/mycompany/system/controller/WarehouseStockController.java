/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.controller;

import com.mycompany.system.model.business.WarehouseStock;
import com.mycompany.system.service.WarehouseStockService;
import java.util.List;
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
@RequestMapping("/warehouse-stock")
public class WarehouseStockController {

    @Autowired
    private WarehouseStockService warehouseStockService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<WarehouseStock>> getAll() {
        return new ResponseEntity<>(warehouseStockService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WarehouseStock> save(@RequestBody WarehouseStock warehouseStock) {
        warehouseStockService.save(warehouseStock);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<WarehouseStock> update(@RequestBody WarehouseStock warehouseStock) {
        warehouseStockService.update(warehouseStock);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WarehouseStock> delete(@PathVariable int id) {
        warehouseStockService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
