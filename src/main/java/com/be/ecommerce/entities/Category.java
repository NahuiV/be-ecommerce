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
@Entity(name = "Category")
@Table(name = "category")
public class Category {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "picture")
    private String picture;
    @Column(name = "active")
    private Boolean active;

    @OneToMany(targetEntity = Product.class)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private List<Product> products;
}
