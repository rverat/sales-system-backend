/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.model.business;

import com.mycompany.inventory.model.business.*;
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
public class Supplier implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("supplierId")
    private String supplierId;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("ruc")
    private String ruc;
    
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    
    @JsonProperty("description")
    private String description;
    
}