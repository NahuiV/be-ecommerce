package com.be.ecommerce.dto;

import lombok.Data;

@Data
public class SupplierDTO {

    private Long id;
    private String phone;
    private String fax;
    private String email;
    private String website;
    private Boolean discountAvailable;
    private String logo; //Este no estoy seguro.
    private Boolean currentOrder;
}
