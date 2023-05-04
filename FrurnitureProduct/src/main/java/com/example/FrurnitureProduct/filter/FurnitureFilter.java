package com.example.FrurnitureProduct.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FurnitureFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        //Getting the authorization header from the HttpServletRequest object.
        String authHeader= httpServletRequest.getHeader("Authorization");
        System.out.println(authHeader);
        //Checking if the authorization header is null or if it doesn't start with "Bearer".
        // If either of these conditions is true, a ServletException is thrown with the message "Token is Missing".
        if(authHeader==null || !authHeader.startsWith("Bearer"))
        {
            throw  new ServletException("Token is Missing");
        }
        else
        {
            //This code is executed if the Authorization header exists in the HTTP request.
            //The code extracts the JWT token from the header by removing the first 7 characters ("Bearer ").
            //It prints a message to the console to indicate whether the token is present or not.
            String token=authHeader.substring(7);
            System.out.println("token is present or not"+token);
            //It sets the secret key used to sign the token as "secretKeyForUser"
            Claims claims= Jwts.parser().setSigningKey("FurnitureKey").parseClaimsJws(token).getBody();
            //prints clain/info on console
            System.out.println("Retrieved Claims : "+ claims);
            //The first attribute ("attr1") is set to the value of the "userEmail" claim.
            //The second attribute ("attr2") is set to the value of the "userRole" claim
            //values are obtained from jwt token
            httpServletRequest.setAttribute("attr1",claims.get("email"));
            httpServletRequest.setAttribute("attr2",claims.get("role"));

            //These two lines extract the values of the "attr1" and "attr2" attributes from the HTTP request
            // and assign them to the "email" and "role" variables.
            String email=(String) httpServletRequest.getAttribute("attr1");
            System.out.println(email);
            String role=(String) httpServletRequest.getAttribute("attr2");
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}

