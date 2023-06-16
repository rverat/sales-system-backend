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
import java.time.LocalDate;

/**
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

    @JsonProperty("userSystem")
    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserSystemDTO userSystem;

    @JsonProperty("customer")
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerDTO customer;

    @JsonProperty("store")
    @ManyToOne
    @JoinColumn(name = "id_store")
    private StoreDTO store;

    @JsonProperty("date")
    @Column(name = "date")
    private LocalDate date;

    @JsonProperty("price")
    @Column(name = "price")
    private BigDecimal price = new BigDecimal("0.00");

    @JsonProperty("discount")
    @Column(name = "discount")
    private BigDecimal discount = new BigDecimal("0.00");

    @JsonProperty("totalPrice")
    @Column(name = "total_price")
    private BigDecimal totalPrice = new BigDecimal("0.00");

    @JsonProperty("cancelSale")
    @Column(name = "cancel_sale")
    private int cancelSale = 0;

    //@JsonProperty("saleDetail")
    //@OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<SaleDetailDTO> saleDetail= new ArrayList<>();

}
