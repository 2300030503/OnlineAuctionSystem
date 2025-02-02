package com.onlineauctionSystem.AuctionSystem.repository;

import com.onlineauctionSystem.AuctionSystem.Entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface  ProductRepository extends MongoRepository<Products, Integer> {

    @Query("{ 'name': { '$regex': ?0, '$options': 'i' } }")
    List<Products> findByNameContaining(String name);

    @Query("{ 'price': { '$lte': ?0 } }")
    List<Products> findByPriceLessThanEqual(double price);
}
