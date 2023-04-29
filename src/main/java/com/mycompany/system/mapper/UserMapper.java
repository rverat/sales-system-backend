/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.User;
import com.mycompany.system.model.business.UserResponse;
import com.mycompany.system.model.thirdparty.UserDTO;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserDTO userToUserDTO(User user);
    UserResponse userDTOToUserRs(UserDTO userDTO);
    
}
