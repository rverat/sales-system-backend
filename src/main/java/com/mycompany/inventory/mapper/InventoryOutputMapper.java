/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.mapper;

import com.mycompany.inventory.model.business.InventoryOutput;
import com.mycompany.inventory.model.business.InventoryOutputResponse;
import com.mycompany.inventory.model.thirdparty.InventoryOutputDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper
public interface InventoryOutputMapper {
    
    InventoryOutputDTO inventoryOutputToInventoryOutputDTO(InventoryOutput inventoryOutput);
    InventoryOutputResponse inventoryOutputDTOToInventoryOutputRs(InventoryOutputDTO inventoryOutputDTO);
    List<InventoryOutputResponse> inventoryOutputDTOToInventoryOutputRs(List<InventoryOutputDTO> inventoryOutputDTO);
}