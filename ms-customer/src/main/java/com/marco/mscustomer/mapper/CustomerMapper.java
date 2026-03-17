package com.marco.mscustomer.mapper;

import com.marco.mscustomer.dto.CustomerRequest;
import com.marco.mscustomer.dto.CustomerResponse;
import com.marco.mscustomer.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request){
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .city(request.city())
                .build();
    }


    public CustomerResponse toCustomerResponse(Customer customer){
        return new CustomerResponse(customer.getId(),
                customer.getFirstName(),customer.getLastName(),customer.getEmail(),customer.getPhone(),customer.getAddress(),customer.getCity());
    }
}
