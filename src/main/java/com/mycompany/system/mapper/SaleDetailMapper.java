/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.SaleDetail;
import com.mycompany.system.model.thirdparty.SaleDetailDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface SaleDetailMapper {

    SaleDetail saleDetailDTOToSaleDetail(SaleDetailDTO saleDetailDTO);

    List<SaleDetail> saleDetailDTOListToSaleDetailList(List<SaleDetailDTO> saleDetailDTOs);

    SaleDetailDTO saleDetailToSaleDetailDTO(SaleDetail saleDetail);

    List<SaleDetailDTO> saleDetailListToSaleDetailDTOList(List<SaleDetail> saleDetails);

}
