package com.be.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "Customer")
@Table(name = "customer")
public class Customer extends Address {
    @Id
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "lastn_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private Boolean active;

    @OneToMany(targetEntity = Order.class)
    @JoinColumn(name = "orders_id",referencedColumnName = "id")
    private List<Order> orders;

    @OneToOne(targetEntity = Address.class)
    private Address address;

}
