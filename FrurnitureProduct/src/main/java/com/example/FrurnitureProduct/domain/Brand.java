package com.example.FrurnitureProduct.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Document
public class Brand {
    @Id

    private int brandId;

    private String brandName;

    private List<Furniture> furnitureList;


}
