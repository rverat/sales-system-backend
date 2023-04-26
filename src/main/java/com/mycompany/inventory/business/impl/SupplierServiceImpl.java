/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.business.impl;

import com.mycompany.inventory.business.SupplierService;
import com.mycompany.inventory.dao.SupplierDAO;
import com.mycompany.inventory.mapper.SupplierMapper;
import com.mycompany.inventory.model.business.Supplier;
import com.mycompany.inventory.model.business.SupplierResponse;
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
public class SupplierServiceImpl implements SupplierService{
    
    @Autowired
    private SupplierMapper mapper;
    
    @Autowired
    private SupplierDAO dao;

    @Override
    public List<SupplierResponse> getAll() {
        return mapper.supplierDTOToSupplierRs(dao.findAll());
    }

    @Override
    public void save(Supplier supplier) {
        dao.save(mapper.supplierToSupplierDTO(supplier));
    }

    @Override
    public void update(Supplier supplier) {
        dao.save(mapper.supplierToSupplierDTO(supplier));
    }

    @Override
    public void delete(int supplierId) {
        dao.deleteById(supplierId);
    }
    
}
