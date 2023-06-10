/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.StoreStock;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ro
 */
public interface StoreStockService {

    List<StoreStock> getAll();
    
    public Optional<StoreStock> findByProductIdAndStoreId(int productId, int storeId);

    void save(StoreStock stock);

    void update(StoreStock stock);

    void delete(int stockId);

}
