/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.SaleDetail;
import java.util.List;

/**
 *
 * @author ro
 */
public interface SaleDetailService {

    List<SaleDetail> getAll();

    void save(SaleDetail saleDetail);
    
    void saveAll(List<SaleDetail> saleDetails);

    void update(SaleDetail saleDetail);

    void delete(int saleDetailId);

}
