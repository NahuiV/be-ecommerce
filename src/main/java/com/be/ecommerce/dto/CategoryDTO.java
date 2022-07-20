package com.be.ecommerce.dto;


import lombok.Data;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private String description;
    private String picture;
    private Boolean active;

}
