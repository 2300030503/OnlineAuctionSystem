package com.onlineauctionSystem.AuctionSystem.controller;
import com.onlineauctionSystem.AuctionSystem.Entity.Products;
import com.onlineauctionSystem.AuctionSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(path="/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/getproducts")
    public ResponseEntity<List<Products>> getProducts() {
        List<Products> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   // 204 - No Content
        }
        return new ResponseEntity<>(products, HttpStatus.OK);  // 200 - OK
    }

    @PostMapping("/createproduct")
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        try {
            Products savedProduct = productService.saveProduct(product);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);  // 201 - Created
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // 500 - Internal Server Error
        }
    }

    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 - No Content
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 - Not Found
        }
    }

    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable("id") Integer id, @RequestBody Products product) {
        try {
            Products updatedProduct = productService.updateProduct(id, product);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);  // 200 - OK
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 - Not Found
        }
    }

    @GetMapping("/products/filter")
    public ResponseEntity<List<Products>> filterProducts(@RequestParam(required = false) String name,
                                                         @RequestParam(required = false) Double price) {
        List<Products> products;
        if (name != null) {
            products = productService.getProductsByName(name);
        } else if (price != null) {
            products = productService.getProductsByPrice(price);
        } else {
            products = productService.getAllProducts();
        }
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
