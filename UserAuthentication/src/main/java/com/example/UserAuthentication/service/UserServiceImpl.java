package com.example.UserAuthentication.service;

import com.example.UserAuthentication.domain.CartDetail;
import com.example.UserAuthentication.domain.User;
import com.example.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User checkLogin(User user) {
        return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }

//    @Override
//    public User getUser(String email) {
//        return userRepository.findById(email).orElse(null);
//    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @Override
//    public CartDetail addCartDetail(String userEmail, CartDetail cartDetail) {
//        User user = getUser(userEmail);
//        if(user != null) {
//            user.getCart().add(cartDetail);
//            userRepository.save(user);
//        }
//        return cartDetail;
//    }
}
