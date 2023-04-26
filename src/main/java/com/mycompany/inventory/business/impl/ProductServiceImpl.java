/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.business.impl;

import com.mycompany.inventory.business.ProductService;
import com.mycompany.inventory.dao.ProductDAO;
import com.mycompany.inventory.mapper.ProductMapper;
import com.mycompany.inventory.model.business.Product;
import com.mycompany.inventory.model.business.ProductResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ro
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductMapper mapper;
    
    @Autowired
    private ProductDAO dao;

    @Override
    public List<ProductResponse> getAll() {
        return mapper.productDTOToProductRs(dao.findAll());
    }

    @Override
    public void save(Product product) {
        dao.save(mapper.productToProductDTO(product));
    }

    @Override
    public void update(Product product) {
        dao.save(mapper.productToProductDTO(product));
    }

    @Override
    public void delete(int productId) {
        dao.deleteById(productId);
    }
    
}
