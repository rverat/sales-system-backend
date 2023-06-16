/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.Supplier;
import com.mycompany.system.model.thirdparty.SupplierDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface SupplierMapper {

    Supplier supplierDTOToSupplier(SupplierDTO supplierDTO);

    List<Supplier> supplierDTOListToSupplierList(List<SupplierDTO> supplierDTO);

    SupplierDTO supplierToSupplierDTO(Supplier supplier);

}
