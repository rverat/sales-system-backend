/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.service.InventoryEntryService;
import com.mycompany.system.dao.InventoryEntryDAO;
import com.mycompany.system.mapper.InventoryEntryMapper;
import com.mycompany.system.model.business.InventoryEntry;
import com.mycompany.system.model.business.InventoryEntryResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ro
 */
@Service
public class InventoryEntryServiceImpl implements InventoryEntryService{
    
    @Autowired
    private InventoryEntryMapper mapper;
   
    @Autowired
    private InventoryEntryDAO dao;
    
    @Override
    public List<InventoryEntryResponse> getAll() {
        return mapper.inventoryEntryDTOToInventoryEntryRs(
                dao.findAll());
    }

    @Override
    public void save(InventoryEntry systemEntry) {
        dao.save(mapper.inventoryEntryToInventoryEntryDTO(systemEntry));
    }

    @Override
    public void update(InventoryEntry systemEntry) {
        dao.save(mapper.inventoryEntryToInventoryEntryDTO(systemEntry));
    }

    @Override
    public void delete(int systemEntryId) {
        dao.deleteById(systemEntryId);
    }  
    
}
