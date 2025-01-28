package com.onlineauctionSystem.AuctionSystem.controller;

import com.onlineauctionSystem.AuctionSystem.Entity.Products;
import com.onlineauctionSystem.AuctionSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.List;
@Controller
@RequestMapping(path="/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Products>>getProducts() {

        List<Products> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 - No Content
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody Products product) {


        try {
            // Set the creation and update timestamps
        //    product.setCreatedAt(new Date());
         //   product.setUpdatedAt(new Date());

            // Save the product to MongoDB
            Products savedProduct = productService.saveProduct(product);

            // Return the saved product with HTTP status 201 (Created)
            return ResponseEntity.status(201).body(savedProduct);
        } catch (Exception e) {
            // Handle any errors and return 500 Internal Server Error
            return ResponseEntity.status(500).build();
        }
    }



}
