package com.tcs.cart_ms.service;


import com.tcs.cart_ms.dto.CartProduct;
import com.tcs.cart_ms.entity.Cart;
import com.tcs.cart_ms.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    RestTemplate restTemplate ;


    public void save(CartProduct cartProduct){
        Cart cart = cartProduct.getCart();
        Map<Integer,Integer> productQuantity = cartProduct.getProductQuantity();

       cartRepo.save(cart);


        for (Map.Entry<Integer, Integer> entry : productQuantity.entrySet()) {
            Integer productId = entry.getKey();
            Integer quantity = entry.getValue();

            HttpEntity<Object> entity = null;
            String url = "http://PRODUCT-MS/product/quantity/{productId}/{quantity}";
            restTemplate.put(url, null, productId, quantity);
        }
    }
    public  void updateCart(Cart cart){
        cartRepo.save(cart);
    }

    public List<Cart> getAllProduct(){
        return cartRepo.findAll();
    }

    public Cart findProductById(int id){
        return cartRepo.findById(id).orElse(null);
    }

    public void delete(int id){
        cartRepo.deleteById(id);
    }
}
