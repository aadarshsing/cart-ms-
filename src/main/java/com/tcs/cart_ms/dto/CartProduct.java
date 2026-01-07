package com.tcs.cart_ms.dto;


import com.tcs.cart_ms.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartProduct {

    Map<Integer,Integer> productQuantity;
    Cart cart;
}
