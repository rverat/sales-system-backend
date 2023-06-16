/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.dao.ProductCategoryDAO;
import com.mycompany.system.mapper.ProductCategoryMapper;
import com.mycompany.system.model.business.ProductCategory;
import com.mycompany.system.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ro
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper mapper;

    @Autowired
    private ProductCategoryDAO dao;

    @Override
    public List<ProductCategory> getAll() {
        return mapper.productCategoryDTOListToProductCategoryList(dao.findAll());
    }

    @Override
    public void save(ProductCategory productCategory) {
        dao.save(mapper.productCategoryToProductCategoryDTO(productCategory));
    }

    @Override
    public void update(ProductCategory productCategory) {
        dao.save(mapper.productCategoryToProductCategoryDTO(productCategory));
    }

    @Override
    public void delete(int productCategoryId) {
        dao.deleteById(productCategoryId);
    }

}
