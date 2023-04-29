/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.model.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
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
public class Product implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("productId")
    private int productId;
    
    @JsonProperty("nombre")
    private String nombre;
    
    @JsonProperty("amount")
    private String amount;
    
    @JsonProperty("categoryId")
    private String categoryId;
         
    @JsonProperty("description")
    private String description;
          
}
