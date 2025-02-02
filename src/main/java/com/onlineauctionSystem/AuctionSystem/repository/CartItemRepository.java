package com.onlineauctionSystem.AuctionSystem.repository;

import com.onlineauctionSystem.AuctionSystem.Entity.CartItem;
import com.onlineauctionSystem.AuctionSystem.Entity.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface CartItemRepository extends MongoRepository<CartItem, Integer> {


}
