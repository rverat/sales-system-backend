/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.ProductCategory;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ro
 */
public interface ProductCategoryService {

    List<ProductCategory> getAll();

    void save(ProductCategory category);

    void update(ProductCategory category);

    void delete(int categoryId);

}
