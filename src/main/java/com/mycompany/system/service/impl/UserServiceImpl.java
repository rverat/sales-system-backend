/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.service.UserService;
import com.mycompany.system.dao.UserDAO;
import com.mycompany.system.mapper.UserMapper;
import com.mycompany.system.model.business.User;
import com.mycompany.system.model.business.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ro
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserMapper mapper;
    
    @Autowired
    private UserDAO dao;

    @Override
    public UserResponse login(User user) {
        
        /*return mapper.userDTOToUserRs(
               dao.findByUserAndPassword(
                       user.getUserName(), user.getPassword()));*/
        return null;
        
        
    }

    @Override
    public void save(User user) {
        dao.save(mapper.userToUserDTO(user));
    }

    @Override
    public void update(User user) {
        dao.save(mapper.userToUserDTO(user));
    }

    @Override
    public void delete(int userId) {
        dao.deleteById(userId);
    }
    
}
