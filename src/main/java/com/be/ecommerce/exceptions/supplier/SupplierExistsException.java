package com.be.ecommerce.exceptions.supplier;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class SupplierExistsException extends  RuntimeException{

    public SupplierExistsException(String message){super(message);}

}
