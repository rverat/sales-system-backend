/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.SaleDetail;
import com.mycompany.system.model.report.SaleReport;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author ro
 */
public interface SaleDetailService {

    List<SaleDetail> getAll();

    Optional<List<SaleDetail>> findBySaleId(int saleId);

    void save(SaleDetail saleDetail);

    void saveAll(List<SaleDetail> saleDetails);

    void update(SaleDetail saleDetail);

    void delete(int saleDetailId);

    Optional<SaleDetail> findBySaleDetailId(int saleDetailId);

    Optional<List<SaleReport>> getSaleReports();

    Optional<List<SaleReport>> getSaleReportsByDate(LocalDate startDate, LocalDate endDate);
}
