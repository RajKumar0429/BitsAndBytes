package com.bitsnbytes.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long CategoryId;

//    public ProductDTO() {}

    // Add this constructor to match the expected parameters
//    public ProductDTO(Long id, String name, String description, Double price, Long CategoryId) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.CategoryId = CategoryId;
//    }
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public Long getCategoryId() {
//        return CategoryId;
//    }
//
//    public void setCategoryId(Long categoryId) {
//        CategoryId = categoryId;
//    }
}
