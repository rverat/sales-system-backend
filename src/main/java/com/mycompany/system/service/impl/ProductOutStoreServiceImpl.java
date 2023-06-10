/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.system.dao.ProductOutStoreDAO;
import com.mycompany.system.mapper.ProductOutStoreMapper;
import com.mycompany.system.model.business.ProductOutStore;
import com.mycompany.system.model.thirdparty.ProductOutStoreDTO;
import com.mycompany.system.service.ProductOutStoreService;
import java.util.Optional;

/**
 *
 * @author ro
 */
@Service
public class ProductOutStoreServiceImpl implements ProductOutStoreService {

    @Autowired
    private ProductOutStoreMapper mapper;

    @Autowired
    private ProductOutStoreDAO dao;

    @Override
    public List<ProductOutStore> getAll() {
        return mapper.productOutStoreDTOListToProductOutStoreList(dao.findAll());
    }
    
     @Override
    public Optional<ProductOutStore> findById(int id) {
         Optional<ProductOutStoreDTO> optional = dao.findById(id);   
        if(optional.isPresent()){
            ProductOutStoreDTO  entryWarehouseDTO = optional.get();          
           return Optional.of(mapper.productOutStoreDTOToProductOutStore(entryWarehouseDTO));       
        }
      return  Optional.empty();
    }

    @Override
    public void save(ProductOutStore productOutStore) {
        dao.save(mapper.productOutStoreToProductOutStoreDTO(productOutStore));
    }

    @Override
    public void update(ProductOutStore productOutStore) {
        dao.save(mapper.productOutStoreToProductOutStoreDTO(productOutStore));
    }

    @Override
    public void delete(int productOutStoreId) {
        dao.deleteById(productOutStoreId);
    }

   
}
