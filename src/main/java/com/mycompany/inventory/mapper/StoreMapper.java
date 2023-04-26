/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.mapper;

import com.mycompany.inventory.model.business.Store;
import com.mycompany.inventory.model.business.StoreResponse;
import com.mycompany.inventory.model.thirdparty.StoreDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper
public interface StoreMapper {
    
    StoreDTO storeToStoreDTO(Store store);
    StoreResponse storeDTOToStoreRs(StoreDTO storeDTO);
    List<StoreResponse> storeDTOToStoreRs(List<StoreDTO> storeDTO);
}
