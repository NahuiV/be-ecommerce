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

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Shipper")
@Table(name = "shipper")
public class Shipper{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne(targetEntity = Address.class)
    private Address address;
}
