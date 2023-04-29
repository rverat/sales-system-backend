/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.InventoryEntry;
import com.mycompany.system.model.business.InventoryEntryResponse;
import java.util.List;

/**
 *
 * @author ro
 */
public interface InventoryEntryService {
    
    List<InventoryEntryResponse> getAll();
    void save(InventoryEntry systemEntry);
    void update(InventoryEntry systemEntry);
    void delete(int systemEntryId);
    
}
