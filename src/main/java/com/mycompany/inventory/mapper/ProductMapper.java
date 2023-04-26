/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.mapper;

import com.mycompany.inventory.model.business.Product;
import com.mycompany.inventory.model.business.ProductResponse;
import com.mycompany.inventory.model.thirdparty.ProductDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */

@Mapper
public interface ProductMapper {
    
    ProductDTO productToProductDTO(Product product);
    ProductResponse productDTOToProductRs(ProductDTO productDTO);
    List<ProductResponse> productDTOToProductRs(List<ProductDTO> productDTO);
}
