package com.example.CartDetails.repository;

import com.example.CartDetails.domain.CartItems;
import com.example.CartDetails.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartRepository extends MongoRepository<User,String> {
//  List<CartItems> findByEmail(String email);


}
