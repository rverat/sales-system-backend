/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.dao;

import com.mycompany.inventory.model.thirdparty.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ro
 */
@Repository
public interface UserDAO extends JpaRepository<UserDTO, Integer>{
 
    UserDTO findByUserAndPassword(String user, String password);
}
