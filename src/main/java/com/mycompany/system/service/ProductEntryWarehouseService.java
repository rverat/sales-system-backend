/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.ProductEntryWarehouse;

import java.util.List;
import java.util.Optional;

/**
 * @author ro
 */
public interface ProductEntryWarehouseService {

    List<ProductEntryWarehouse> getAll();

    Optional<ProductEntryWarehouse> findById(int id);

    void save(ProductEntryWarehouse entry);

    void update(ProductEntryWarehouse entry);

    void delete(int entryId);

}
