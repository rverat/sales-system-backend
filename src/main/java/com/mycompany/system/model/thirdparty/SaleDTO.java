/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.model.thirdparty;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ro
 */
@Getter
@Setter
@Entity
@Table(name = "sale")
public class SaleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty("userId")
    @JoinColumn(name = "id_user")
    private int userId;

    @JsonProperty("customerId")
    @JoinColumn(name = "id_customer")
    private int customerId;

    @JsonProperty("storeId")
    @JoinColumn(name = "id_store")
    private int storeId;

    @JsonProperty("date")
    @Column(name = "date")
    private LocalDate date;

    @JsonProperty("price")
    @Column(name = "price")
    private BigDecimal price;

    @JsonProperty("discount")
    @Column(name = "discount")
    private BigDecimal discount = new BigDecimal("0.00");

    @JsonProperty("total_price")
    @Column(name = "total_price")
    private BigDecimal totalPrice = new BigDecimal("0.00");

}