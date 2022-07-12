package com.be.ecommerce.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "Shipper")
@Table(name = "shipper")
public class Shipper extends Address{
    @Id
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "url")
    private String url;
    @Column(name = "taxes")
    private BigDecimal taxes;

    @OneToMany(targetEntity = Order.class)
    @JoinColumn(name = "shipper_id",referencedColumnName = "id")
    private List<Order> orders;
}
