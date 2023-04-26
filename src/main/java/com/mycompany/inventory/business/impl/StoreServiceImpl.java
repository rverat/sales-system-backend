/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.business.impl;

import com.mycompany.inventory.business.StoreService;
import com.mycompany.inventory.dao.StoreDAO;
import com.mycompany.inventory.mapper.StoreMapper;
import com.mycompany.inventory.model.business.Store;
import com.mycompany.inventory.model.business.StoreResponse;
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
public class StoreServiceImpl implements StoreService{
    
    @Autowired
    private StoreMapper mapper;
    
    @Autowired
    private StoreDAO dao;

    @Override
    public List<StoreResponse> getAll() {
        return mapper.storeDTOToStoreRs(dao.findAll());
    }

    @Override
    public void save(Store store) {
        dao.save(mapper.storeToStoreDTO(store));
    }

    @Override
    public void update(Store store) {
        dao.save(mapper.storeToStoreDTO(store));
    }

    @Override
    public void delete(int storeId) {
        dao.deleteById(storeId);
    }
    
}
