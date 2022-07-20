package com.be.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PaymentDTO {

    private Long id;
    private String paymentType;
    private BigDecimal amount;
    private Date paymentDate;
    private Date lastUpdate;

}
