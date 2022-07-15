package com.be.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Supplier")
@Table(name = "supplier")
public class Supplier{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "email")
    private String email;
    @Column(name = "website")
    private String website;
    @Column(name = "discount_available")
    private Boolean discountAvailable;
    @Column(name = "logo")
    private String logo;
    @Column(name = "current_order")
    private Boolean currentOrder;

    @OneToMany(targetEntity = Product.class)
    @JoinColumn(name = "supplier_id",referencedColumnName = "id")
    private List<Product> products;

    @OneToOne(targetEntity = Address.class)
    private Address address;
}
