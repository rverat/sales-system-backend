/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.dao.SaleDAO;
import com.mycompany.system.mapper.SaleMapper;
import com.mycompany.system.model.business.Sale;
import com.mycompany.system.model.thirdparty.SaleDTO;
import com.mycompany.system.service.SaleService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ro
 */
@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDAO saleDAO;

    @Autowired
    private SaleMapper saleMapper;

    @Override
    public List<Sale> getAll() {
        return saleMapper.saleDTOListToSaleList(saleDAO.findAll());
    }

    @Override
    public void save(Sale sale) {
        saleDAO.save(saleMapper.saleToSaleDTO(sale));
    }

    @Override
    public void update(Sale sale) {
        saleDAO.save(saleMapper.saleToSaleDTO(sale));
    }

    @Override
    public void delete(int saleId) {
        saleDAO.deleteById(saleId);
    }

    @Override
    public Sale saveAndReturnData(Sale sale) {
        
        sale.setDate(LocalDate.now());
        
        SaleDTO saleDTO = saleDAO.save(saleMapper.saleToSaleDTO(sale));
        return saleMapper.saleDTOToSale(saleDTO);
    }

}
