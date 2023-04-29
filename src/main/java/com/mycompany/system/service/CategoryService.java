/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.Category;
import com.mycompany.system.model.business.CategoryResponse;
import java.util.List;

/**
 *
 * @author ro
 */
public interface CategoryService {
    
    List<CategoryResponse> getAll();
    void save(Category category);
    void update(Category category);
    void delete(int categoryId);
    
}