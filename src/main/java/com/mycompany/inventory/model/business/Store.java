/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.model.business;

import com.mycompany.inventory.model.business.*;
import com.mycompany.inventory.model.thirdparty.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
public class Store implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("storeId")
    private int storeId;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("address")
    private String address;
    
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    
    @JsonProperty("description")
    private String description;
    
}
