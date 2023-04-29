/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.Store;
import com.mycompany.system.model.business.StoreResponse;
import com.mycompany.system.model.thirdparty.StoreDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface StoreMapper {
    
    StoreDTO storeToStoreDTO(Store store);
    StoreResponse storeDTOToStoreRs(StoreDTO storeDTO);
    List<StoreResponse> storeDTOToStoreRs(List<StoreDTO> storeDTO);
}
