package com.example.FrurnitureProduct.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Furniture {

    private int furnitureId;
    private String furnitureName;
    private String price;
}
