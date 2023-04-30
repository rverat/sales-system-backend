/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.dao.WarehouseStockDAO;
import com.mycompany.system.mapper.WarehouseStockMapper;
import com.mycompany.system.model.business.WarehouseStock;
import com.mycompany.system.service.WarehouseStockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ro
 */
@Service
public class WarehouseStockServiceImpl implements WarehouseStockService {

    @Autowired
    private WarehouseStockMapper mapper;

    @Autowired
    private WarehouseStockDAO dao;

    @Override
    public List<WarehouseStock> getAll() {
        return mapper.warehouseStockDTOListToWarehouseStockList(dao.findAll());
    }

    @Override
    public void save(WarehouseStock warehouseStock) {
        dao.save(mapper.warehouseStockToWarehouseStockDTO(warehouseStock));
    }

    @Override
    public void update(WarehouseStock warehouseStock) {
        dao.save(mapper.warehouseStockToWarehouseStockDTO(warehouseStock));
    }

    @Override
    public void delete(int warehouseStockId) {
        dao.deleteById(warehouseStockId);
    }

}
