/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.Sale;

import java.util.List;
import java.util.Optional;

/**
 * @author ro
 */
public interface SaleService {

    List<Sale> getAll();

    void save(Sale sale);

    void update(Sale sale);

    void delete(int saleId);

    Sale saveAndReturnData(Sale sale);

    Optional<Sale> findById(int id);
}
