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
@Entity(name = "Payment")
@Table(name = "payment")
public class Payment {
    @Id
    private Long id;
    @Column(name = "payment_type")
    private String paymentType;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "payment_date")
    private Date paymentDate;
    @Column(name = "last_update")
    private Date lastUpdate;
}
