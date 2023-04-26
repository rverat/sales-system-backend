/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.business.impl;

import com.mycompany.inventory.business.UserService;
import com.mycompany.inventory.dao.UserDAO;
import com.mycompany.inventory.mapper.UserMapper;
import com.mycompany.inventory.model.business.User;
import com.mycompany.inventory.model.business.UserResponse;
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
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserMapper mapper;
    
    @Autowired
    private UserDAO dao;

    @Override
    public UserResponse login(User user) {
        return mapper.userDTOToUserRs(
               dao.findByUserAndPassword(
                       user.getUserName(), user.getPassword()));
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
