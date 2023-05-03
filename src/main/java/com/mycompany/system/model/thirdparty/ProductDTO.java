/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.model.thirdparty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mycompany.system.model.business.ProductCategory;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "product")
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;
    
    @JsonProperty("productCategory")
    @ManyToOne
    @JoinColumn(name = "id_product_category")
    private ProductCategoryDTO productCategory;

    @JsonProperty("description")
    @Column(name = "description")
    private String description;

    @JsonProperty("price")
    @Column(name = "price")
    private BigDecimal price = new BigDecimal("0.00");
    

}
