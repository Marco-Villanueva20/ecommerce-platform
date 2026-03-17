package com.marco.mscustomer.mapper;

import com.marco.mscustomer.dto.CustomerRequest;
import com.marco.mscustomer.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request){
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .city(request.city())
                .build();
    }
}
