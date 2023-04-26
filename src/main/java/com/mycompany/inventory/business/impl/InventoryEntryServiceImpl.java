/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.business.impl;

import com.mycompany.inventory.business.InventoryEntryService;
import com.mycompany.inventory.dao.InventoryEntryDAO;
import com.mycompany.inventory.mapper.InventoryEntryMapper;
import com.mycompany.inventory.model.business.InventoryEntry;
import com.mycompany.inventory.model.business.InventoryEntryResponse;
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
    public void save(InventoryEntry inventoryEntry) {
        dao.save(mapper.inventoryEntryToInventoryEntryDTO(inventoryEntry));
    }

    @Override
    public void update(InventoryEntry inventoryEntry) {
        dao.save(mapper.inventoryEntryToInventoryEntryDTO(inventoryEntry));
    }

    @Override
    public void delete(int inventoryEntryId) {
        dao.deleteById(inventoryEntryId);
    }  
    
}
