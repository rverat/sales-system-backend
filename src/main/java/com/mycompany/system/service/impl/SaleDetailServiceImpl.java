/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.dao.SaleDetailDAO;
import com.mycompany.system.mapper.SaleDetailMapper;
import com.mycompany.system.model.business.SaleDetail;
import com.mycompany.system.model.report.SaleReport;
import com.mycompany.system.model.thirdparty.SaleDetailDTO;
import com.mycompany.system.service.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ro
 */
@Service
public class SaleDetailServiceImpl implements SaleDetailService {

    @Autowired
    private SaleDetailMapper mapper;

    @Autowired
    private SaleDetailDAO dao;

    private static List<SaleReport> getSaleReports(List<Object[]> saleReportObjects) {
        List<SaleReport> saleReports = new ArrayList<>();

        int rowNUmber = 1;
        for (Object[] saleReportObject : saleReportObjects) {
            SaleReport saleReport = new SaleReport();
            saleReport.setRowNumber(rowNUmber);
            saleReport.setIdSale((Integer) saleReportObject[0]);
            saleReport.setIdSaleDetail((Integer) saleReportObject[1]);
            saleReport.setIdProduct((Integer) saleReportObject[2]);
            saleReport.setProductName((String) saleReportObject[3]);
            saleReport.setQuantity((Integer) saleReportObject[4]);
            saleReport.setUnitPrice((BigDecimal) saleReportObject[5]);
            saleReport.setTotalPriceDetail((BigDecimal) saleReportObject[6]);
            saleReport.setCancelSaleDetail((Integer) saleReportObject[7]);
            saleReport.setDiscount((BigDecimal) saleReportObject[8]);
            saleReport.setFinalPrice((BigDecimal) saleReportObject[9]);

            // Convert java.sql.Date to java.time.LocalDate
            Date saleDateSql = (Date) saleReportObject[10];
            LocalDate saleDate = saleDateSql.toLocalDate();
            saleReport.setSaleDate(saleDate);

            saleReport.setIdUser((Integer) saleReportObject[11]);
            saleReport.setIdCustomer((Integer) saleReportObject[12]);
            saleReport.setIdStore((Integer) saleReportObject[13]);
            saleReport.setCancelSale((Integer) saleReportObject[14]);

            saleReports.add(saleReport);

            rowNUmber++;
        }
        return saleReports;
    }

    @Override
    public List<SaleDetail> getAll() {
        return mapper.saleDetailDTOListToSaleDetailList(dao.findAll());
    }

    @Override
    public Optional<List<SaleDetail>> findBySaleId(int saleId) {
        Optional<List<SaleDetailDTO>> optional = dao.findBySaleId(saleId);

        if (optional.get().isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.saleDetailDTOListToSaleDetailList(optional.get()));
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

    @Override
    public Optional<SaleDetail> findBySaleDetailId(int saleDetailId) {
        Optional<SaleDetailDTO> optional = dao.findById(saleDetailId);

        if (optional.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.saleDetailDTOToSaleDetail(optional.get()));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<SaleReport>> getSaleReports() {
        List<Object[]> saleReportObjects = dao.getSaleReports();
        List<SaleReport> saleReports = getSaleReports(saleReportObjects);

        return Optional.of(saleReports);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<SaleReport>> getSaleReportsByDate(LocalDate startDate, LocalDate endDate) {
        List<Object[]> saleReportObjects = dao.getSaleReportsByDate(startDate, endDate);
        List<SaleReport> saleReports = getSaleReports(saleReportObjects);

        return Optional.of(saleReports);
    }

}
