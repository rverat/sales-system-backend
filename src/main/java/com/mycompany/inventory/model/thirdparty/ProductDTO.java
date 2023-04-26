/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.model.thirdparty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author ro
 */

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
@Entity
@Table(name = "product")
public class ProductDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("productId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private int productId;
    
    @JsonProperty("nombre")
    @Column(name = "nombre")
    private String nombre;
    
    @JsonProperty("amount")
    @Column(name = "amount")
    private String amount;
    
    @JsonProperty("categoryId")
    @Column(name = "categoryId")
    private String categoryId;
     
    @JsonProperty("description")
    @Column(name = "description")
    private String description;
          
}
