package com.be.ecommerce.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "Orders")
@Table(name = "orders")
public class Order {
    @Id
    private Long id;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "ship_date")
    private Date shipDate;
}
