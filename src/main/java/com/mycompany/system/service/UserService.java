/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.User;
import com.mycompany.system.model.business.UserResponse;

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
