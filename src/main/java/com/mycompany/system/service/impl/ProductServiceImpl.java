/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.dao.ProductDAO;
import com.mycompany.system.mapper.ProductMapper;
import com.mycompany.system.model.business.Product;
import com.mycompany.system.model.thirdparty.ProductDTO;
import com.mycompany.system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author ro
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductDAO dao;

    @Override
    public List<Product> getAll() {
        return mapper.productDTOListToProductList(dao.findAll());
    }

    @Override
    public Optional<Product> findById(int id) {

        Optional<ProductDTO> optional = dao.findById(id);

        if (!optional.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(mapper.productDTOToProduct(optional.get()));
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
