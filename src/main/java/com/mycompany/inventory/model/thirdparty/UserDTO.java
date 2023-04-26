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
@Table(name = "user")
public class UserDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @JsonProperty("userId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    
    @JsonProperty("firstName")
    @Column(name = "firstName")
    private String firstName;
    
    @JsonProperty("lastName")
    @Column(name = "lastName")
    private String lastName;
    
    @JsonProperty("userName")
    @Column(name = "userName")
    private String userName;
    
    @JsonProperty("password")
    @Column(name = "password")
    private String password;
    
    @JsonProperty("phoneNumber")
    @Column(name = "phoneNumber")
    private String phoneNumber;
    
}
