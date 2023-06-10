/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.service.SupplierService;
import com.mycompany.system.dao.SupplierDAO;
import com.mycompany.system.mapper.SupplierMapper;
import com.mycompany.system.model.business.Supplier;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ro
 */
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper mapper;

    @Autowired
    private SupplierDAO dao;

    @Override
    public List<Supplier> getAll() {
        return mapper.supplierDTOListToSupplierList(dao.findAll());
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
