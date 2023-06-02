/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.dao.UserSystemDAO;
import com.mycompany.system.mapper.UserSystemMapper;
import com.mycompany.system.model.business.UserSystem;
import com.mycompany.system.model.thirdparty.UserSystemDTO;
import com.mycompany.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author ro
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserSystemDAO dao;

    @Autowired
    UserSystemMapper mapper;

    @Override
    public List<UserSystem> getAll() {
        return mapper.userSystemDTOListToUserSystemList(dao.findAll());
    }

    @Override
    public Optional<UserSystem> findByUserName(String userName) {

        Optional<UserSystemDTO> userSystemDTO = dao.findByUserName(userName);

        if (!userSystemDTO.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(mapper.userSystemDTOToUserSystem(userSystemDTO.get()));
    }

    @Override
    public void save(UserSystem user) {
        dao.save(mapper.userSystemToUserSystemDTO(user));
    }

    @Override
    public void update(UserSystem user) {
        dao.save(mapper.userSystemToUserSystemDTO(user));
    }

    @Override
    public void delete(int userId) {
        dao.deleteById(userId);
    }


}
