/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.StoreStock;
import com.mycompany.system.model.thirdparty.StoreStockDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface StoreStockMapper {

    StoreStock storeStockDTOToStoreStock(StoreStockDTO storeStockDTO);

    List<StoreStock> storeStockDTOListToStoreStockList(List<StoreStockDTO> storeStockDTO);

    StoreStockDTO storeStockToStoreStockDTO(StoreStock storeStock);

}
