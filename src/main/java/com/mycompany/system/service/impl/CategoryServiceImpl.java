/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.service.CategoryService;
import com.mycompany.system.mapper.CategoryMapper;
import com.mycompany.system.model.business.Category;
import com.mycompany.system.model.business.CategoryResponse;
import com.mycompany.system.dao.CategoryDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ro
 */
@Service
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
