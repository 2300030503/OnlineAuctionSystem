package com.onlineauctionSystem.AuctionSystem.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CartItem")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CartItem {
    @Id
    private Integer id;
    private String productId;
    private int quantity;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }
}
