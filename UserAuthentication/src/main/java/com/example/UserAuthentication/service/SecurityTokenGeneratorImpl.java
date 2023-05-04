package com.example.UserAuthentication.service;

import com.example.UserAuthentication.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {

    @Override
    public Map<String, String> generateToken(User user) {
        System.out.println(user);
        //creates a new HashMap called result, which will be
        // used to store the generated token
        Map<String,String> result= new HashMap<>();
        //creates a new HashMap called userdata, which will be used to store
        // the user data that will be included in the token.
        Map<String,Object> userdata= new HashMap<>();
        //add properties into userdata
        userdata.put("email",user.getEmail() );
        userdata.put("role",user.getRole());
        userdata.put("address",user.getAddress());

        userdata.put("name",user.getName());
        //The Jwts.builder() method starts building the token
        String myToken= Jwts.builder().setClaims(userdata)
                //setIssuedAt sets the issue time of the token to the current time.
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"FurnitureKey")
                // used to generate the final token as a compact string.
                .compact();
        result.put("Token",myToken);
        result.put("email", user.getEmail());
        result.put("Message","login successful");
        result.put("Role", user.getRole());
        return result;
    }
}
