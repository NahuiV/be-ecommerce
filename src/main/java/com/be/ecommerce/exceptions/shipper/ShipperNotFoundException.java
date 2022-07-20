package com.be.ecommerce.exceptions.shipper;

public class ShipperNotFoundException extends RuntimeException{
    public ShipperNotFoundException(String message){
        super(message);
    }
}
