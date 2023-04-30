/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.SaleDetail;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ro
 */
public interface SaleDetailService {

    List<SaleDetail> getAll();

    void save(SaleDetail saleDetail);

    void update(SaleDetail saleDetail);

    void delete(int saleDetailId);

}
