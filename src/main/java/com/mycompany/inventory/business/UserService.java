/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.business;

import com.mycompany.inventory.model.business.User;
import com.mycompany.inventory.model.business.UserResponse;

/**
 *
 * @author ro
 */
public interface UserService {
    
    UserResponse login(User user);
    void save(User user);
    void update(User user);
    void delete(int userId);
    
}
