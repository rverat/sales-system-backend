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
import java.time.LocalDate;

/**
 * @author ro
 */
@Getter
@Setter
@Entity
@Table(name = "product_out_to_store")
public class ProductOutStoreDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty("product")
    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductDTO product;

    @JsonProperty("store")
    @ManyToOne
    @JoinColumn(name = "id_store")
    private StoreDTO store;

    @JsonProperty("quantity")
    @Column(name = "quantity")
    private int quantity;

    @JsonProperty("date")
    @Column(name = "date")
    private LocalDate date;

    @JsonProperty("ticket_Cancelled")
    @Column(name = "ticket_Cancelled")
    private boolean ticketCancelled;

}
