/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.mapper;

import com.mycompany.inventory.model.business.InventoryEntry;
import com.mycompany.inventory.model.business.InventoryEntryResponse;
import com.mycompany.inventory.model.thirdparty.InventoryEntryDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper
public interface InventoryEntryMapper {
    
    InventoryEntryDTO inventoryEntryToInventoryEntryDTO(InventoryEntry inventoryEntry);
    InventoryEntryResponse inventoryEntryDTOToInventoryEntryRs(InventoryEntryDTO inventoryEntryDTO);
    List<InventoryEntryResponse> inventoryEntryDTOToInventoryEntryRs(List<InventoryEntryDTO> inventoryEntryDTO);
}
