package com.onlineauctionSystem.AuctionSystem.controller;
import com.onlineauctionSystem.AuctionSystem.Entity.Products;
import com.onlineauctionSystem.AuctionSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(path="/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getproducts")
    public List<Products> getProducts() {

        List<Products> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return null;  // 204 - No Content
        }
        return products;
    }

    @PostMapping("/createproduct")
    public Products createProduct(@RequestBody Products products) {


            Products savedProduct = productService.saveProduct(products);

            // Return the saved product with HTTP status 201 (Created)
return savedProduct;
    }



}
