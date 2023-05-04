package com.example.CartDetails.service;

import com.example.CartDetails.domain.CartItems;
import com.example.CartDetails.domain.User;
import com.example.CartDetails.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CartServiceImpl implements CartService {


    private CartRepository cartItemsRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartItemsRepository) {

        this.cartItemsRepository = cartItemsRepository;
    }
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(90000)+100000;
}

//    @Override
//    public CartItems addItemToCart(String email, CartItems cartItems) {
//        Optional<User> userOptional = cartItemsRepository.findById(email);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            List<CartItems> cart = user.getCart();
//            cart.add(cartItems);
//            user.setCart(cart);
//            return cartItemsRepository.save(user).getCart().get(cart.size() - 1);
//        } else {
//            User newUser = new User(email, List.of(cartItems));
//            return cartItemsRepository.save(newUser).getCart().get(0);
//}
//    }
//@Override
//public CartItems addItemToCart(String email, CartItems cartItem) {
//    // First, check if the user exists
//    Optional<User> userOptional = cartItemsRepository.findById(email);
//    if (userOptional.isPresent()) {
//        User user = userOptional.get();
//        // Update the user's cart by adding the new item
//        List<CartItems> cart = user.getCart();
//        cart.add(cartItem);
//        user.setCart(cart);
//        // Save the updated user information to the database
//        return cartItemsRepository.save(user)
//                .getCart()
//                .stream()
//                .filter(item -> item.equals(cartItem))
//                .findFirst()
//                .orElse(null);
//    } else {
//        // Create a new user with the given email and add the new cart item
//        User newUser = new User(email, List.of(cartItem));
//        return cartItemsRepository.save(newUser)
//                .getCart()
//                .stream()
//                .filter(item -> item.equals(cartItem))
//                .findFirst()
//                .orElse(null);
//    }
//}
@Override
public CartItems addItemToCart(String email, CartItems cartItems) {
    Optional<User> userOptional = cartItemsRepository.findById(email);
    if (userOptional.isPresent()) {
        User user = userOptional.get();
        List<CartItems> cart = user.getCart();
        cart.add(cartItems);
        user.setCart(cart);
        // It then gets the updated cart from the saved User object and returns the last item in the cart.
        return cartItemsRepository.save(user).getCart().get(cart.size() - 1);
    } else {
        User newUser = new User(email, List.of(cartItems));
        // The reason why we use index 0 is that when a new user is created, their cart will be empty by default.
        return cartItemsRepository.save(newUser).getCart().get(0);
}
}
    public Optional<User> getCartItemsByEmail(String email) {
        return cartItemsRepository.findById(email);
    }


}


