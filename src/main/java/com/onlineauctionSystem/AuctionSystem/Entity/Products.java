package com.onlineauctionSystem.AuctionSystem.Entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Products{
    @Id
    private Integer id;

    private String name;
    private String description;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
