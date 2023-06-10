/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.system.dao.ProductEntryWarehouseDAO;
import com.mycompany.system.mapper.ProductEntryWarehouseMapper;
import com.mycompany.system.model.business.ProductEntryWarehouse;
import com.mycompany.system.model.thirdparty.ProductEntryWarehouseDTO;
import com.mycompany.system.service.ProductEntryWarehouseService;
import java.util.Optional;

/**
 *
 * @author ro
 */
@Service
public class ProductEntryWarehouseServiceImpl implements ProductEntryWarehouseService {

    @Autowired
    private ProductEntryWarehouseMapper mapper;

    @Autowired
    private ProductEntryWarehouseDAO dao;

    @Override
    public List<ProductEntryWarehouse> getAll() {
        return mapper.productEntryWarehouseDTOListToProductEntryWarehouseList(dao.findAll());
    }
    
      @Override
    public Optional<ProductEntryWarehouse> findById(int id) {
        Optional<ProductEntryWarehouseDTO> optional = dao.findById(id);   
        if(optional.isPresent()){
            ProductEntryWarehouseDTO  entryWarehouseDTO = optional.get();          
           return Optional.of(mapper.productEntryWarehouseDTOToProductEntryWarehouse(entryWarehouseDTO));       
        }
      return  Optional.empty();
    }

    @Override
    public void save(ProductEntryWarehouse productEntryWarehouse) {
        dao.save(mapper.productEntryWarehouseToProductEntryWarehouseDTO(productEntryWarehouse));
    }

    @Override
    public void update(ProductEntryWarehouse productEntryWarehouse) {
        dao.save(mapper.productEntryWarehouseToProductEntryWarehouseDTO(productEntryWarehouse));
    }

    @Override
    public void delete(int productEntryWarehouseId) {
        dao.deleteById(productEntryWarehouseId);
    }

}
