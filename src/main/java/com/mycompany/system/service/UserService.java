/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.UserSystem;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ro
 */
public interface UserService {

    List<UserSystem> getAll();

    Optional<UserSystem> findByUserName(String userName);

    void save(UserSystem user);

    void update(UserSystem user);

    void delete(int userId);

}
