package com.example.UserAuthentication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class CartDetail {

    private int cartId;
    private int furnitureId;
    private String furnitureName;
    private String price;



}
