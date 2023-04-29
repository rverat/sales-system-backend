/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.InventoryEntry;
import com.mycompany.system.model.business.InventoryEntryResponse;
import com.mycompany.system.model.thirdparty.InventoryEntryDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface InventoryEntryMapper {
    
    InventoryEntryDTO inventoryEntryToInventoryEntryDTO(InventoryEntry inventoryEntry);
    InventoryEntryResponse inventoryEntryDTOToInventoryEntryRs(InventoryEntryDTO inventoryEntryDTO);
    List<InventoryEntryResponse> inventoryEntryDTOToInventoryEntryRs(List<InventoryEntryDTO> inventoryEntryDTO);
}
