package com.cjss.ecomapp.error;


public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Could not find customer " + id);
    }
}