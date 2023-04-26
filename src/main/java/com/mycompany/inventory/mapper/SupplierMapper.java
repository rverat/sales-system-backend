/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inventory.mapper;

import com.mycompany.inventory.model.business.Supplier;
import com.mycompany.inventory.model.business.SupplierResponse;
import com.mycompany.inventory.model.thirdparty.SupplierDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper
public interface SupplierMapper {
    
    SupplierDTO supplierToSupplierDTO(Supplier supplier);
    SupplierResponse supplierDTOToSupplierRs(SupplierDTO supplierDTO);
    List<SupplierResponse> supplierDTOToSupplierRs(List<SupplierDTO> supplierDTO);
}
