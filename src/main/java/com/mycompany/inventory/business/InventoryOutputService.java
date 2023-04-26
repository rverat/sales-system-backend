/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.business;

import com.mycompany.inventory.model.business.InventoryOutput;
import com.mycompany.inventory.model.business.InventoryOutputResponse;
import java.util.List;

/**
 *
 * @author ro
 */
public interface InventoryOutputService {
    
    List<InventoryOutputResponse> getAll();
    void save(InventoryOutput inventoryOutput);
    void update(InventoryOutput inventoryOutput);
    void delete(int inventoryOutputId);
    
}
