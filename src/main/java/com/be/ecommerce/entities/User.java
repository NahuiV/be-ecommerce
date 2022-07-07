package com.be.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Getter
@Setter
@ToString
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "telephone",nullable = false)
    private String telephone;

    @Column(name = "created_at",nullable = false)
    private LocalDate createdAt;

    @Column(name = "modified_at",nullable = false)
    private LocalDate modifiedAt;

}

