package com.marco.mscustomer.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }

    public static CustomerNotFoundException fromId(String id){
        return  new CustomerNotFoundException("Customer Not Found with id: "+id);
    }
}
