package com.onlineauctionSystem.AuctionSystem.repository;

import com.onlineauctionSystem.AuctionSystem.Entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface  ProductRepository extends MongoRepository<Products, Long> {

    List<Products> findByCategory(String category);

    List<Products> findByPriceBetween(Double minPrice, Double maxPrice);
}
