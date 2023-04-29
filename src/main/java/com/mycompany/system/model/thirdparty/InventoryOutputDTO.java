/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.model.thirdparty;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "inventory_output")
public class InventoryOutputDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("inventoryOId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventoryOId")
    private int inventoryOId;
    
    @JsonProperty("productId")
    @Column(name = "productId")
    private int productId;
    
    @JsonProperty("userId")
    @Column(name = "userId")
    private int userId;
    
    @JsonProperty("storeId")
    @Column(name = "storeId")
    private int storeId;
    
    @JsonProperty("cantidad")
    @Column(name = "cantidad")
    private int cantidad;
    
    @JsonProperty("registerDate")
    @Column(name = "registerDate")
    private Date registerDate;
    
    @JsonProperty("description")
    @Column(name = "description")
    private String description;
    
}
