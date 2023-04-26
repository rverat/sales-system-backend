/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory.model.thirdparty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.UUID;
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
@Table(name = "store")
public class StoreDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("storeId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeId")
    private int storeId;
    
    @JsonProperty("name")
    @Column(name = "name")
    private String name;
    
    @JsonProperty("address")
    @Column(name = "address")
    private String address;
    
    @JsonProperty("phoneNumber")
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    @JsonProperty("description")
    @Column(name = "description")
    private String description;
    
}
