package com.example.FrurnitureProduct.repository;
import com.example.FrurnitureProduct.domain.Brand;
import com.example.FrurnitureProduct.domain.Furniture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FurnitureRepository extends MongoRepository<Brand,Integer> {



    @Query(value = "{'furnitureList.furnitureId': ?0}")
    List<Brand> findByFurnitureId(int furnitureId);

    @Query(value="{ 'furnitureList.furnitureName' : ?0}")
    List<Brand> findByName(String furnitureName );

}
