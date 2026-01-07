package com.tcs.cart_ms.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private double productCode;
    private String productCat;
    private int productquantity;
    private String productDesc;
    private double productAmount;
}
