/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.dao;

import com.mycompany.system.model.thirdparty.ProductEntryWarehouseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author ro
 */
@Repository
public interface ProductEntryWarehouseDAO extends JpaRepository<ProductEntryWarehouseDTO, Integer> {

    Optional<ProductEntryWarehouseDTO> findById(int id);

}
