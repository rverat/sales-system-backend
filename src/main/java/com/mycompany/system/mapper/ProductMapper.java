/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.Product;
import com.mycompany.system.model.thirdparty.ProductDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productDTOToProduct(ProductDTO productDTO);

    List<Product> productDTOListToProductList(List<ProductDTO> productDTO);

    ProductDTO productToProductDTO(Product product);

}
