/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.ProductEntryWarehouse;
import java.util.List;

/**
 *
 * @author ro
 */
public interface ProductEntryWarehouseService {

    List<ProductEntryWarehouse> getAll();

    void save(ProductEntryWarehouse entry);

    void update(ProductEntryWarehouse entry);

    void delete(int entryId);

}
