/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.model.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ro
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private int id;
    
    @JsonProperty("userSystem")
    private UserSystem userSystem;
    
    @JsonProperty("customer")
    private Customer customer;
    
    @JsonProperty("store")
    private Store store;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("discount")
    private BigDecimal discount = new BigDecimal("0.00");

    @JsonProperty("total_price")
    private BigDecimal totalPrice = new BigDecimal("0.00");

}
