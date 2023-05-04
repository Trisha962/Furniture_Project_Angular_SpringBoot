package com.example.FrurnitureProduct.service;

import com.example.FrurnitureProduct.domain.Brand;
import com.example.FrurnitureProduct.domain.Furniture;
import com.example.FrurnitureProduct.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FurnitureServiceImpl implements IFurnitureService {

    private FurnitureRepository furnitureRepository;


    @Autowired
    public FurnitureServiceImpl(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;

    }

    @Override
    public Brand addUser(Brand brand) {

        return furnitureRepository.insert(brand);
    }

//    @Override
//    public Brand getUsers(String email) {
//        System.out.println(email);
//        return furnitureRepository.findById(email).get();
//    }

    @Override
    public List<Brand> getAllUsersByAdmin() {
        return furnitureRepository.findAll();
    }

    @Override
    public List<Brand> updateFurniture(Furniture furniture) {
    List<Brand> furnitureList = furnitureRepository.findByFurnitureId(furniture.getFurnitureId());
    for(Brand update: furnitureList){
        for(Furniture obj: update.getFurnitureList()){
            if(obj.getFurnitureId()== furniture.getFurnitureId()){
                obj.setFurnitureName(furniture.getFurnitureName());
                obj.setFurnitureId(furniture.getFurnitureId());
                obj.setPrice(furniture.getPrice());
            }
        }
        furnitureRepository.save(update);
    }
        return furnitureList;
    }


    @Override
    public List<Brand> deleteFurnitureId(Furniture furniture) {
        List<Brand> brandsWithFurniture = furnitureRepository.findByFurnitureId(furniture.getFurnitureId());
        for (Brand brand : brandsWithFurniture) {
            List<Furniture> furnitureList = brand.getFurnitureList();
            furnitureList.removeIf(f -> f.getFurnitureId() == furniture.getFurnitureId());
            brand.setFurnitureList(furnitureList);
            furnitureRepository.save(brand);
        }
        return brandsWithFurniture;
    }



}




