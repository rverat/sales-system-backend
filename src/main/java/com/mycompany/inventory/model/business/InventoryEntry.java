/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.model.business;

import com.mycompany.inventory.model.business.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
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
public class InventoryEntry implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("inventoryOId")
    private int inventoryOId;
    
    @JsonProperty("productId")
    private int productId;
    
    @JsonProperty("supplierId")
    private int supplierId;
    
    @JsonProperty("userId")
    private int userId;
    
    @JsonProperty("cantidad")
    private int cantidad;
    
    @JsonProperty("price")
    private double price;
    
    @JsonProperty("priceAll")
    private double priceAll;
    
    @JsonProperty("registerDate")
    private Date registerDate;
    
    @JsonProperty("description")
    private String description;
    
}
