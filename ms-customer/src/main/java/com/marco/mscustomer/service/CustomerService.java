package com.marco.mscustomer.service;

import com.marco.mscustomer.dto.CustomerRequest;
import com.marco.mscustomer.mapper.CustomerMapper;
import com.marco.mscustomer.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    public final CustomerRepository customerRepository;
    public final CustomerMapper customerMapper;
    public String createCustomer(@Valid CustomerRequest request) {
        var customer = customerMapper.toCustomer(request);
        var savedCustomer = customerRepository.save(customer);
        return savedCustomer.getId();

    }
}
