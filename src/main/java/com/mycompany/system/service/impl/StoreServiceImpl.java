/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.dao.StoreDAO;
import com.mycompany.system.mapper.StoreMapper;
import com.mycompany.system.model.business.Store;
import com.mycompany.system.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ro
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDAO storeDAO;

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Store> getAll() {
        return storeMapper.storeDTOListToStoreList(storeDAO.findAll());
    }

    @Override
    public void save(Store store) {
        storeDAO.save(storeMapper.storeToStoreDTO(store));
    }

    @Override
    public void update(Store store) {
        storeDAO.save(storeMapper.storeToStoreDTO(store));
    }

    @Override
    public void delete(int storeId) {
        storeDAO.deleteById(storeId);
    }

}
