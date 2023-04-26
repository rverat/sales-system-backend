/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.mapper;

import com.mycompany.inventory.model.business.User;
import com.mycompany.inventory.model.business.UserResponse;
import com.mycompany.inventory.model.thirdparty.UserDTO;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper
public interface UserMapper {
    
    UserDTO userToUserDTO(User user);
    UserResponse userDTOToUserRs(UserDTO userDTO);
    
}
