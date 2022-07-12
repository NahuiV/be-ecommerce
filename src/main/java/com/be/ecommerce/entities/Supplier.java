package com.be.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "Supplier")
@Table(name = "supplier")
public class Supplier extends Address {
    @Id
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
}
