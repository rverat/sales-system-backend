/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.Sale;
import com.mycompany.system.model.thirdparty.SaleDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface SaleMapper {

    Sale saleDTOToSale(SaleDTO saleDTO);

    List<Sale> saleDTOListToSaleList(List<SaleDTO> saleDTO);

    SaleDTO saleToSaleDTO(Sale sale);

}
