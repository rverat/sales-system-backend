/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author ro
 */
public interface ProductService {

    List<Product> getAll();

    Optional<Product> findById(int id);

    void save(Product product);

    void update(Product product);

    void delete(int productId);

}
