package com.example.CartDetails.service;

import com.example.CartDetails.domain.CartItems;
import com.example.CartDetails.domain.User;

import java.util.Optional;

public interface CartService {





    public CartItems addItemToCart(String email,CartItems cartItems);


    Optional<User> getCartItemsByEmail(String email);
}
