package com.be.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisterDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
