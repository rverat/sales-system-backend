/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.ProductCategory;
import com.mycompany.system.model.thirdparty.ProductCategoryDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {

    ProductCategory productCategoryDTOToProductCategory(ProductCategoryDTO productCategoryDTO);

    List<ProductCategory> productCategoryDTOListToProductCategoryList(List<ProductCategoryDTO> productCategoryDTO);

    ProductCategoryDTO productCategoryToProductCategoryDTO(ProductCategory productCategory);

}
