package com.example.UserAuthentication.controller;

import com.example.UserAuthentication.domain.CartDetail;
import com.example.UserAuthentication.domain.User;
import com.example.UserAuthentication.service.IUserService;
import com.example.UserAuthentication.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user/v1")
public class UserController {
    private IUserService iUserService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(IUserService iUserService, SecurityTokenGenerator securityTokenGenerator) {
        this.iUserService = iUserService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    // http://localhost:3333/api/user/v1/register
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        System.out.println("reaches controller");

        user.setRole("User-Role");
        System.out.println(user);
        return new ResponseEntity<>(iUserService.registerUser(user), HttpStatus.CREATED);
    }


    // http://localhost:3333/api/user/v1/login
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody  User user){
        User retrievedUser=iUserService.checkLogin(user);
        System.out.println(retrievedUser);
        if(retrievedUser!= null ){
            System.out.println(retrievedUser);


            return  new ResponseEntity(securityTokenGenerator.generateToken(retrievedUser),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Authentication failed,Please try again!!",HttpStatus.EXPECTATION_FAILED);
        }
    }

    //http://localhost:3333/api/user/v1/allUsers
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = iUserService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
}
//    @PostMapping("/cart/{email}")
//    public ResponseEntity<CartDetail> addCartDetail(@PathVariable String email, @RequestBody CartDetail cartDetail) {
//        CartDetail addedCartDetail = iUserService.addCartDetail(email, cartDetail);
//        return new ResponseEntity<>(addedCartDetail, HttpStatus.CREATED);
//    }









}
