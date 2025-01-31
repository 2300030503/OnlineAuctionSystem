package com.onlineauctionSystem.AuctionSystem.service;

import com.onlineauctionSystem.AuctionSystem.Entity.Products;
import com.onlineauctionSystem.AuctionSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Products> getFilteredProducts(String category, String priceRange) {
        List<Products> products = productRepository.findAll();

       /* if (category != null && !category.isEmpty()) {
            products = productRepository.findByCategory(category);
        }

        if (priceRange != null && !priceRange.isEmpty()) {
            String[] priceParts = priceRange.split("-");
            Double minPrice = Double.parseDouble(priceParts[0]);
            Double maxPrice = Double.parseDouble(priceParts[1]);
            products = productRepository.findByPriceBetween(minPrice, maxPrice);
        }*/

        return products;
    }

    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }



}
