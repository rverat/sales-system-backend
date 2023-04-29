/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.Product;
import com.mycompany.system.model.business.ProductResponse;
import java.util.List;

/**
 *
 * @author ro
 */
public interface ProductService {
    
    List<ProductResponse> getAll();
    void save(Product product);
    void update(Product product);
    void delete(int productId);
    
}
