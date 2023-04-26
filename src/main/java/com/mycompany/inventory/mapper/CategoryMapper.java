/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.mapper;

import com.mycompany.inventory.model.business.Category;
import com.mycompany.inventory.model.business.CategoryResponse;
import com.mycompany.inventory.model.thirdparty.CategoryDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper
public interface CategoryMapper {
    
    CategoryDTO categoryToCategoryDTO(Category category);
    CategoryResponse categoryDTOToCategoryRs(CategoryDTO categoryDTO);
    List<CategoryResponse> categoryDTOToCategoryRs(List<CategoryDTO> categoryDTO);
}
