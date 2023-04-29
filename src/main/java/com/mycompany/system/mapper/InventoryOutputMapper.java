/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.InventoryOutput;
import com.mycompany.system.model.business.InventoryOutputResponse;
import com.mycompany.system.model.thirdparty.InventoryOutputDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface InventoryOutputMapper {
    
    InventoryOutputDTO systemOutputToInventoryOutputDTO(InventoryOutput systemOutput);
    InventoryOutputResponse systemOutputDTOToInventoryOutputRs(InventoryOutputDTO systemOutputDTO);
    List<InventoryOutputResponse> systemOutputDTOToInventoryOutputRs(List<InventoryOutputDTO> systemOutputDTO);
}