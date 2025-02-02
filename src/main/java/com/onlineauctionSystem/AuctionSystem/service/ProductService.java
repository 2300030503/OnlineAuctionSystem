package com.onlineauctionSystem.AuctionSystem.service;

import com.onlineauctionSystem.AuctionSystem.Entity.Products;
import com.onlineauctionSystem.AuctionSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Products> getProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    public List<Products> getProductsByPrice(double price) {
        return productRepository.findByPriceLessThanEqual(price);
    }

    public Products saveProduct(Products products) {
        return productRepository.save(products);
    }


    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public Products updateProduct(Integer id, Products products) {
        Optional<Products> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Products existingProduct = optionalProduct.get();
            existingProduct.setName(products.getName());
            existingProduct.setDescription(products.getDescription());
         //   existingProduct.setPrice(productDetails.getPrice());
            // Update other fields as necessary
            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with id " + id);
        }
    }



}
