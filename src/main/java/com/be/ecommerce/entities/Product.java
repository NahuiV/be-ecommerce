package com.be.ecommerce.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "Product")
@Table(name = "product")
public class Product{
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "modified_at")
    private Date modifiedAt;
    @Column(name = "deleted_at")
    private Date deletedAt;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "product_available")
    private Boolean productAvailable;
    @Column(name = "discount_available")
    private Boolean discountAvailable;
}
