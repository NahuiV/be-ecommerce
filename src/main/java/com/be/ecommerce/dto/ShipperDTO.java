package com.be.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShipperDTO {

    private Long id;
    private String companyName;
    private String phone;
    private String url;
    private BigDecimal taxes;

}
