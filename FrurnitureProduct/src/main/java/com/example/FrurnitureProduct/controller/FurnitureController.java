package com.example.FrurnitureProduct.controller;

import com.example.FrurnitureProduct.domain.Brand;
import com.example.FrurnitureProduct.domain.Furniture;
import com.example.FrurnitureProduct.repository.FurnitureRepository;
import com.example.FrurnitureProduct.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user/furniture/v1")
public class FurnitureController {
    private IFurnitureService iFurnitureService;
    private FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureController(IFurnitureService iFurnitureService, FurnitureRepository furnitureRepository) {
        this.iFurnitureService = iFurnitureService;
        this.furnitureRepository = furnitureRepository;
    }

    //http://localhost:3300/api/user/furniture/v1/addBrand   ------------post
    @PostMapping("/addBrand")
    public ResponseEntity addUser(@RequestBody Brand brand) {
        return new ResponseEntity(iFurnitureService.addUser(brand), HttpStatus.OK);
    }

    //http://localhost:3300/api/user/furniture/v2/getUsersInfoForHome
    @GetMapping("/getBrandInfoForHome")
    public ResponseEntity getUsersInfoForHome() {
        return new ResponseEntity(iFurnitureService.getAllUsersByAdmin(), HttpStatus.OK);
    }


//    //http://localhost:3300/api/user/furniture/v1/getUsers   ------------get
//    @GetMapping("/getUsers")
//    public ResponseEntity getUsersInformation(HttpServletRequest httpServletRequest) {
//        String email = (String) httpServletRequest.getAttribute("attr1");
//        return new ResponseEntity(iFurnitureService.getUsers(email), HttpStatus.OK);
//    }

    //http://localhost:3300/api/user/furniture/v1/admin/getAllUsers  -get

    @GetMapping("/admin/getAllUsers")
    public ResponseEntity getUsersInformationByAdmin(HttpServletRequest request) {
        if (request.getAttribute("attr2").equals("admin")) {

            return new ResponseEntity(iFurnitureService.getAllUsersByAdmin(), HttpStatus.OK);
        } else {
            return new ResponseEntity("Bad request-Only admin allowed", HttpStatus.BAD_REQUEST);
        }
    }
   // http://localhost:3300/api/user/furniture/v1/update/{id}
    @PutMapping("/update")
    public ResponseEntity updateDetail( @RequestBody Furniture furniture) {
        System.out.println("inside");
        return new ResponseEntity(iFurnitureService.updateFurniture(furniture),HttpStatus.OK);
}
    // http://localhost:3300/api/user/furniture/v1/delete/furniture/
    @DeleteMapping("/delete/furniture/{furnitureId}")
    public ResponseEntity<List<Brand>> deleteFurniture(@PathVariable int furnitureId) {
        Furniture furniture = new Furniture();
        furniture.setFurnitureId(furnitureId);
        List<Brand> updatedBrands = iFurnitureService.deleteFurnitureId(furniture);
        return new ResponseEntity<>(updatedBrands, HttpStatus.OK);
    }


}

//http://localhost:3300/api/user/furniture/v1/delete -delete

//    @DeleteMapping("/delete")
//    public ResponseEntity deleteUser(HttpServletRequest httpServletRequest) {
//        String email = (String) httpServletRequest.getAttribute("attr1");
//        System.out.println(email);
//        return new ResponseEntity(iFurnitureService.deleteUser(email), HttpStatus.OK);
//    }