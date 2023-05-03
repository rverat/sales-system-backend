/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.model.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.system.model.thirdparty.ProductDTO;
import com.mycompany.system.model.thirdparty.StoreDTO;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ro
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOutStore implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private int id;

    @JsonProperty("product")
    private Product product;

    @JsonProperty("store")
    private Store store;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("date")
    private LocalDate date;
    
    @JsonProperty("ticket_Cancelled")
    private boolean ticketCancelled;

}
