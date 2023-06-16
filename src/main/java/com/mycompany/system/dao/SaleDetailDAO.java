/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.dao;

import com.mycompany.system.model.thirdparty.SaleDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author ro
 */
@Repository
public interface SaleDetailDAO extends JpaRepository<SaleDetailDTO, Integer> {

    Optional<List<SaleDetailDTO>> findBySaleId(int idSale);

    @Procedure(name = "public.getsalereports", outputParameterName = "result")
    List<Object[]> getSaleReports();

    @Procedure(name = "public.getsalereportsbydate", outputParameterName = "result")
    List<Object[]> getSaleReportsByDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}

