package com.be.ecommerce.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
}
