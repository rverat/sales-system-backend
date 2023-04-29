/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.InventoryOutput;
import com.mycompany.system.model.business.InventoryOutputResponse;
import java.util.List;

/**
 *
 * @author ro
 */
public interface InventoryOutputService {
    
    List<InventoryOutputResponse> getAll();
    void save(InventoryOutput systemOutput);
    void update(InventoryOutput systemOutput);
    void delete(int systemOutputId);
    
}
