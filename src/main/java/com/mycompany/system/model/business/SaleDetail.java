/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.model.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

/**
 *
 * @author ro
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private int id;

    @JsonProperty("sale")
    private Sale sale;

    @JsonProperty("product")
    private Product product;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("unitPrice")
    private BigDecimal unitPrice = new BigDecimal("0.00");

    @JsonProperty("discount")
    private BigDecimal discount = new BigDecimal("0.00");

    @JsonProperty("totalPrice")
    private BigDecimal totalPrice = new BigDecimal("0.00");

    @JsonProperty("cancelSaleDetail")
    private int cancelSaleDetail = 0;

}
