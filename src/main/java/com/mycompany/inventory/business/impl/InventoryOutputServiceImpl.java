/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.business.impl;

import com.mycompany.inventory.business.InventoryOutputService;
import com.mycompany.inventory.dao.InventoryOutputDAO;
import com.mycompany.inventory.mapper.InventoryOutputMapper;
import com.mycompany.inventory.model.business.InventoryOutput;
import com.mycompany.inventory.model.business.InventoryOutputResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ro
 */
@Service
@AllArgsConstructor
public class InventoryOutputServiceImpl implements InventoryOutputService{
    
    @Autowired
    private InventoryOutputMapper mapper;
    
    @Autowired
    private InventoryOutputDAO dao;

    @Override
    public List<InventoryOutputResponse> getAll() {
        return mapper.inventoryOutputDTOToInventoryOutputRs(
                dao.findAll());
    }

    @Override
    public void save(InventoryOutput inventoryOutput) {
        dao.save(mapper.inventoryOutputToInventoryOutputDTO(inventoryOutput));
    }

    @Override
    public void update(InventoryOutput inventoryOutput) {
        dao.save(mapper.inventoryOutputToInventoryOutputDTO(inventoryOutput));
    }

    @Override
    public void delete(int inventoryOutputId) {
        dao.deleteById(inventoryOutputId);
    }
    
}
