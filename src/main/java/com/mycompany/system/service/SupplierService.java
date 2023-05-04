/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.Supplier;
import java.util.List;

/**
 *
 * @author ro
 */
public interface SupplierService {

    List<Supplier> getAll();

    void save(Supplier supplier);

    void update(Supplier supplier);

    void delete(int supplierId);

}
