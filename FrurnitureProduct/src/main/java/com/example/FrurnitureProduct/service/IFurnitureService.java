package com.example.FrurnitureProduct.service;

import com.example.FrurnitureProduct.domain.Brand;
import com.example.FrurnitureProduct.domain.Furniture;

import java.util.List;

public interface IFurnitureService {
    public Brand addUser(Brand brand);

//    public Brand getUsers(String email);

    public List<Brand> getAllUsersByAdmin();

   // boolean updateFurniture( int furnitureId,Furniture furniture);
    List<Brand> updateFurniture(Furniture furniture);
    List<Brand> deleteFurnitureId(Furniture furniture);



}


