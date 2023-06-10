/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.ProductOutStore;
import com.mycompany.system.model.thirdparty.ProductOutStoreDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface ProductOutStoreMapper {

    ProductOutStore productOutStoreDTOToProductOutStore(ProductOutStoreDTO productOutStoreDTO);

    List<ProductOutStore> productOutStoreDTOListToProductOutStoreList(List<ProductOutStoreDTO> productOutStoreDTO);

    ProductOutStoreDTO productOutStoreToProductOutStoreDTO(ProductOutStore productOutStore);

}
