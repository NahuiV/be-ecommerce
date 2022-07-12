package com.be.ecommerce.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "Address")
@Table(name = "address")
public class Address {
    @Id
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "address2")
    private String address2;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "location")
    private String location;
}
