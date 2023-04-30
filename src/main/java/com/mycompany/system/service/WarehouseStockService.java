/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.WarehouseStock;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ro
 */
public interface WarehouseStockService {

    List<WarehouseStock> getAll();

    void save(WarehouseStock stock);

    void update(WarehouseStock stock);

    void delete(int stockId);

}
