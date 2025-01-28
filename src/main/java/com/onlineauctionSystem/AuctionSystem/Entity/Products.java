package com.onlineauctionSystem.AuctionSystem.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "Products") // MongoDB collection name
@AllArgsConstructor
@Data
@Builder
public class Products{
    @Id
    private String id;

    private String name;
    private String description;
    private Double price;
    private String category;
    private Long quantity;
    private Date createdAt;
    private Date updatedAt;
}
