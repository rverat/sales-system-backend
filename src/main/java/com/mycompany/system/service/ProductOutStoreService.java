/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.ProductOutStore;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ro
 */
public interface ProductOutStoreService {

    List<ProductOutStore> getAll();
    
    public Optional<ProductOutStore> findById(int id);

    void save(ProductOutStore out);

    void update(ProductOutStore out);

    void delete(int outId);

}
