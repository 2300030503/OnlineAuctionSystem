package com.onlineauctionSystem.AuctionSystem.controller;

import com.onlineauctionSystem.AuctionSystem.Entity.CartItem;
import com.onlineauctionSystem.AuctionSystem.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {



        @Autowired
        private CartItemService cartService;

        @GetMapping
        public ResponseEntity<List<CartItem>> getAllCartItems() {
        List<CartItem> cartItems = cartService.getAllCartItems();
        if (cartItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

        @PostMapping
        public ResponseEntity<CartItem> addCartItem(@RequestBody CartItem cartItem) {
        try {
            CartItem savedCartItem = cartService.addCartItem(cartItem);
            return new ResponseEntity<>(savedCartItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCartItem(@PathVariable("id") Integer id) {
        try {
            cartService.deleteCartItem(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
