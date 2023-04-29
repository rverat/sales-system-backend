/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.Category;
import com.mycompany.system.model.business.CategoryResponse;
import com.mycompany.system.model.thirdparty.CategoryDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {
        
    CategoryDTO categoryToCategoryDTO(Category category);
    CategoryResponse categoryDTOToCategoryRs(CategoryDTO categoryDTO);
    List<CategoryResponse> categoryDTOToCategoryRs(List<CategoryDTO> categoryDTO);
}
