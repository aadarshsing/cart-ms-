package com.tcs.cart_ms.service;


import com.tcs.cart_ms.entity.Cart;
import com.tcs.cart_ms.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;


    public void save(Cart cart){
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
