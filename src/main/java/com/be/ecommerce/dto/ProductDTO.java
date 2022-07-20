package com.be.ecommerce.dto;

import lombok.Data;

import java.time.LocalDate;
import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
    private LocalDate deletedAt;
    private Integer stock;
    private Boolean productAvailable;
    private Boolean discountAvailable;
}
