package com.example.CartDetails.controller;

import com.example.CartDetails.domain.CartItems;

import com.example.CartDetails.domain.User;
import com.example.CartDetails.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/cart/v1")
public class CartController {
    private CartService cartService;


    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;

    }

@PutMapping("/cart")
public ResponseEntity<?> AddTOCart(HttpServletRequest request, @RequestBody CartItems cartItem) {
    String email = (String) request.getAttribute("attr1");
    CartItems addedCartItem = cartService.addItemToCart(email, cartItem);
    if (addedCartItem == null) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(addedCartItem, HttpStatus.CREATED);
}
}

//    @GetMapping("/cart-items/{email}")
//    public ResponseEntity<List<CartItems>> getCartItemsByEmail(@PathVariable String email) {
//        List<CartItems> cartItems = cartService.getCartItemsByEmail(email);
//        if (cartItems.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(cartItems, HttpStatus.OK);
//    }

    //http://localhost:3309/api/cart/v1/cartByEmail
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getAllCartData(@PathVariable  String email){
        return new ResponseEntity(cartService.getCartItemsByEmail(email), HttpStatus.OK);
    }

//   public List<CartItems> getCartItemsByEmail(HttpServletRequest request) {
////    String email = (String) request.getAttribute("attr1");
//  List<CartItems> cartItems = cartService.getCartItemsByEmail(email);
//    if (cartItems.isEmpty()) {
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    return new ResponseEntity<>(cartItems, HttpStatus.OK);
//}


}

