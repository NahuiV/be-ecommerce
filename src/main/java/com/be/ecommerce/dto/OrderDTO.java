package com.be.ecommerce.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {

    private Long id;
    private Date orderDate;
    private Date shipDate;

}
