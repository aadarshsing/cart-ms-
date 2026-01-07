package com.tcs.cart_ms.controller;


import com.tcs.cart_ms.dto.CartProduct;
import com.tcs.cart_ms.entity.Cart;
import com.tcs.cart_ms.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping
    public ResponseEntity<List<Cart>> getAllProducts(){
        List<Cart> products = cartService.getAllProduct();
        if(products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(products,HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Cart> findProductById(@PathVariable int id){
        Cart cart = cartService.findProductById(id);
        if(cart != null){
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity saveProduct( @RequestBody CartProduct cartProduct){
        cartService.save(cartProduct);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity updateCart(@PathVariable int id, @RequestBody Cart cart){
        Cart existingCart = cartService.findProductById(id);

        if(existingCart != null){
            cartService.updateCart(cart);
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBookById(@PathVariable int id){
         Cart product =cartService.findProductById(id);
        if(product != null){
            cartService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
