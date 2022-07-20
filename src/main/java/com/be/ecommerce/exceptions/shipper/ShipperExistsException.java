package com.be.ecommerce.exceptions.shipper;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class ShipperExistsException extends RuntimeException{

    public ShipperExistsException(String message){
        super(message);
    }
}
