/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.Store;
import java.util.List;

/**
 *
 * @author ro
 */
public interface StoreService {

    List<Store> getAll();

    void save(Store store);

    void update(Store store);

    void delete(int storeId);

}
