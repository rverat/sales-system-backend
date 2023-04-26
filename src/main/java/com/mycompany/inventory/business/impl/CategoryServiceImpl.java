/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.business.impl;

import com.mycompany.inventory.business.CategoryService;
import com.mycompany.inventory.mapper.CategoryMapper;
import com.mycompany.inventory.model.business.Category;
import com.mycompany.inventory.model.business.CategoryResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompany.inventory.dao.CategoryDAO;

/**
 *
 * @author ro
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryMapper mapper;
    
    @Autowired
    private CategoryDAO dao;

    @Override
    public List<CategoryResponse> getAll() {
        return mapper.categoryDTOToCategoryRs(dao.findAll());
    }

    @Override
    public void save(Category category) {        
        dao.save(mapper.categoryToCategoryDTO(category));
    }

    @Override
    public void update(Category category) {
       dao.save(mapper.categoryToCategoryDTO(category));
    }

    @Override
    public void delete(int categoryId) {
        dao.deleteById(categoryId);
    }
    
}
