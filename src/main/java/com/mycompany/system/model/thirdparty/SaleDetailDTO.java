/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.model.thirdparty;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author ro
 */
@Getter
@Setter
@Entity
@Table(name = "sale_detail")
public class SaleDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty("sale")
    @ManyToOne
    @JoinColumn(name = "id_sale")
    private SaleDTO sale;

    @JsonProperty("product")
    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductDTO product;

    @JsonProperty("quantity")
    @Column(name = "quantity")
    private int quantity;

    @JsonProperty("unitPrice")
    @Column(name = "unit_price")
    private BigDecimal unitPrice = new BigDecimal("0.00");

    @JsonProperty("discount")
    @Column(name = "discount")
    private BigDecimal discount = new BigDecimal("0.00");

    @JsonProperty("totalPrice")
    @Column(name = "total_price")
    private BigDecimal totalPrice = new BigDecimal("0.00");

    @JsonProperty("cancelSaleDetail")
    @Column(name = "cancel_sale_detail")
    private int cancelSaleDetail = 0;

}
