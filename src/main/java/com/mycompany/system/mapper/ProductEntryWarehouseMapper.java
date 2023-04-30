/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.ProductEntryWarehouse;
import com.mycompany.system.model.thirdparty.ProductEntryWarehouseDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface ProductEntryWarehouseMapper {

    ProductEntryWarehouse productEntryWarehouseDTOToProductEntryWarehouse(ProductEntryWarehouseDTO productEntryWarehouseDTO);

    List<ProductEntryWarehouse> productEntryWarehouseDTOListToProductEntryWarehouseList(List<ProductEntryWarehouseDTO> productEntryWarehouseDTO);

    ProductEntryWarehouseDTO productEntryWarehouseToProductEntryWarehouseDTO(ProductEntryWarehouse productEntryWarehouse);

}