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
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "product_entry_to_warehouse")
public class ProductEntryWarehouseDTO implements Serializable {

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

    @JsonProperty("product")
    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductDTO product;

    @JsonProperty("supplier")
    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private SupplierDTO supplier;

    @JsonProperty("quantity")
    @Column(name = "quantity")
    private int quantity;

    @JsonProperty("unitPrice")
    @Column(name = "unit_price")
    private BigDecimal unitPrice = new BigDecimal("0.00");

    @JsonProperty("totalPrice")
    @Column(name = "total_price")
    private BigDecimal totalPrice = new BigDecimal("0.00");

    @JsonProperty("discount")
    @Column(name = "discount")
    private BigDecimal discount = new BigDecimal("0.00");

    @JsonProperty("date")
    @Column(name = "date")
    private LocalDate date;

    @JsonProperty("ticketCancelled")
    @Column(name = "ticket_cancelled")
    private boolean ticketCancelled = false;

}
