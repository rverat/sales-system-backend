/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.dao;

import com.mycompany.inventory.model.thirdparty.InventoryEntryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ro
 */
@Repository
public interface InventoryEntryDAO extends JpaRepository<InventoryEntryDTO, Integer>{
    
}
