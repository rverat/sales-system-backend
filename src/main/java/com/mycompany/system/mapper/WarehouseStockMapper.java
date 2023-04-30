/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.WarehouseStock;
import com.mycompany.system.model.thirdparty.WarehouseStockDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface WarehouseStockMapper {

    WarehouseStock warehouseStockDTOToWarehouseStock(WarehouseStockDTO warehouseStockDTO);

    List<WarehouseStock> warehouseStockDTOListToWarehouseStockList(List<WarehouseStockDTO> warehouseStockDTO);

    WarehouseStockDTO warehouseStockToWarehouseStockDTO(WarehouseStock warehouseStock);

}
