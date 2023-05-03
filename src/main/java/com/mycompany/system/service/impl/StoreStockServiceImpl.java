/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.dao.StoreStockDAO;
import com.mycompany.system.mapper.StoreStockMapper;
import com.mycompany.system.model.business.StoreStock;
import com.mycompany.system.model.thirdparty.StoreStockDTO;
import com.mycompany.system.service.StoreStockService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ro
 */
@Service
public class StoreStockServiceImpl implements StoreStockService {

    @Autowired
    private StoreStockMapper mapper;

    @Autowired
    private StoreStockDAO dao;

    @Override
    public List<StoreStock> getAll() {
        return mapper.storeStockDTOListToStoreStockList(dao.findAll());
    }

    @Override
    public Optional<StoreStock> findByProductIdAndStoreId(int productId, int storeId) {
        Optional<StoreStockDTO> optional = dao.findByProductIdAndStoreId(productId, storeId);   
        
        if(optional.isPresent()){
            StoreStockDTO  warehouseStockDTO = optional.get();          
           return Optional.of(mapper.storeStockDTOToStoreStock(warehouseStockDTO));       
        }
      return  Optional.empty();
    }
    
    @Override
    public void save(StoreStock storeStock) {
        dao.save(mapper.storeStockToStoreStockDTO(storeStock));
    }

    @Override
    public void update(StoreStock storeStock) {
        dao.save(mapper.storeStockToStoreStockDTO(storeStock));
    }

    @Override
    public void delete(int storeStockId) {
        dao.deleteById(storeStockId);
    }

 
}
