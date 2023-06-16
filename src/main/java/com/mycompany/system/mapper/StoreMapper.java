/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.Store;
import com.mycompany.system.model.thirdparty.StoreDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface StoreMapper {

    Store StoreDTOToStore(StoreDTO storeDTO);

    List<Store> storeDTOListToStoreList(List<StoreDTO> storeDTO);

    StoreDTO storeToStoreDTO(Store store);

}
