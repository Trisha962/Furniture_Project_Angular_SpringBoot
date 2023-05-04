package com.example.UserAuthentication.service;

import com.example.UserAuthentication.domain.CartDetail;
import com.example.UserAuthentication.domain.User;

import java.util.List;

public interface IUserService {
    public User registerUser(User user) ;
    public User checkLogin(User user);
//    User getUser(String email);
    public List<User> getAllUsers();
//    CartDetail addCartDetail(String userEmail, CartDetail cartDetail);
}
