/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.service.InventoryOutputService;
import com.mycompany.system.dao.InventoryOutputDAO;
import com.mycompany.system.mapper.InventoryOutputMapper;
import com.mycompany.system.model.business.InventoryOutput;
import com.mycompany.system.model.business.InventoryOutputResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ro
 */
@Service
public class InventoryOutputServiceImpl implements InventoryOutputService{
    
    @Autowired
    private InventoryOutputMapper mapper;
    
    @Autowired
    private InventoryOutputDAO dao;
    
    @Override
    public List<InventoryOutputResponse> getAll() {
        return mapper.systemOutputDTOToInventoryOutputRs(
                dao.findAll());
    }

    @Override
    public void save(InventoryOutput systemOutput) {
        dao.save(mapper.systemOutputToInventoryOutputDTO(systemOutput));
    }

    @Override
    public void update(InventoryOutput systemOutput) {
        dao.save(mapper.systemOutputToInventoryOutputDTO(systemOutput));
    }

    @Override
    public void delete(int systemOutputId) {
        dao.deleteById(systemOutputId);
    }
    
}
