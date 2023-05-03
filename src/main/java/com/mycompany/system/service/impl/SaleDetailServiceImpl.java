/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.dao.SaleDetailDAO;
import com.mycompany.system.mapper.SaleDetailMapper;
import com.mycompany.system.model.business.SaleDetail;
import com.mycompany.system.service.SaleDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ro
 */
@Service
public class SaleDetailServiceImpl implements SaleDetailService {

    @Autowired
    private SaleDetailMapper mapper;

    @Autowired
    private SaleDetailDAO dao;

    @Override
    public List<SaleDetail> getAll() {
        return mapper.saleDetailDTOListToSaleDetailList(dao.findAll());
    }

    @Override
    public void save(SaleDetail saleDetail) {
        dao.save(mapper.saleDetailToSaleDetailDTO(saleDetail));
    }
    
    
    @Override
    public void saveAll(List<SaleDetail> saleDetails) {
        dao.saveAll(mapper.saleDetailListToSaleDetailDTOList(saleDetails));
    }

    @Override
    public void update(SaleDetail saleDetail) {
        dao.save(mapper.saleDetailToSaleDetailDTO(saleDetail));
    }

    @Override
    public void delete(int saleDetailId) {
        dao.deleteById(saleDetailId);
    }

   
}
