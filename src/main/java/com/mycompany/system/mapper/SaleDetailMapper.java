/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.mapper;

import com.mycompany.system.model.business.SaleDetail;
import com.mycompany.system.model.thirdparty.SaleDetailDTO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ro
 */
@Mapper(componentModel = "spring")
public interface SaleDetailMapper {

    SaleDetail saleDetailDTOToSaleDetail(SaleDetailDTO saleDetailDTO);

    List<SaleDetail> saleDetailDTOListToSaleDetailList(List<SaleDetailDTO> saleDetailDTO);

    SaleDetailDTO saleDetailToSaleDetailDTO(SaleDetail saleDetail);

}
