package com.be.ecommerce.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
}
