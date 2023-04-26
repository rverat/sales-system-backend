/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.business;

import com.mycompany.inventory.model.business.InventoryEntry;
import com.mycompany.inventory.model.business.InventoryEntryResponse;
import java.util.List;

/**
 *
 * @author ro
 */
public interface InventoryEntryService {
    
    List<InventoryEntryResponse> getAll();
    void save(InventoryEntry inventoryEntry);
    void update(InventoryEntry inventoryEntry);
    void delete(int inventoryEntryId);
    
}
