package com.be.ecommerce.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private Long id;
    private String address;
    private String address2;
    private String city;
    private String district;
    private String postalCode;
    private String location;

}
