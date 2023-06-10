/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.UserSystem;
import com.mycompany.system.model.thirdparty.UserSystemDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface UserSystemMapper {

    UserSystem userSystemDTOToUserSystem(UserSystemDTO userSystemDTO);

    List<UserSystem> userSystemDTOListToUserSystemList(List<UserSystemDTO> userSystemDTO);

    UserSystemDTO userSystemToUserSystemDTO(UserSystem userSystem);

}
