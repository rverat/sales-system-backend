package com.mycompany.system.model.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleReport {

    @JsonProperty("rowNumber")
    private int rowNumber;

    @JsonProperty("idSaleDetail")
    private int idSaleDetail;

    @JsonProperty("idSale")
    private int idSale;

    @JsonProperty("idProduct")
    private int idProduct;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("unitPrice")
    private BigDecimal unitPrice;

    @JsonProperty("totalPriceDetail")
    private BigDecimal totalPriceDetail;

    @JsonProperty("cancelSaleDetail")
    private int cancelSaleDetail;

    @JsonProperty("discount")
    private BigDecimal discount;

    @JsonProperty("finalPrice")
    private BigDecimal finalPrice;

    @JsonProperty("saleDate")
    private LocalDate saleDate;

    @JsonProperty("idUser")
    private int idUser;

    @JsonProperty("idCustomer")
    private int idCustomer;

    @JsonProperty("idStore")
    private int idStore;

    @JsonProperty("cancelSale")
    private int cancelSale;

}
