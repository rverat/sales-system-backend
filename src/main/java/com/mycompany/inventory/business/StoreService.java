/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.business;

import com.mycompany.inventory.model.business.Store;
import com.mycompany.inventory.model.business.StoreResponse;
import java.util.List;

/**
 *
 * @author ro
 */
public interface StoreService {
    
    List<StoreResponse> getAll();
    void save(Store store);
    void update(Store store);
    void delete(int storeId);
    
}
