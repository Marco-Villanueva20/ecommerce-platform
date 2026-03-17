package com.marco.mscustomer.service;

import com.marco.mscustomer.dto.CustomerRequest;
import com.marco.mscustomer.dto.CustomerResponse;
import com.marco.mscustomer.entity.Customer;
import com.marco.mscustomer.mapper.CustomerMapper;
import com.marco.mscustomer.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void updateCustomer(String customerId, CustomerRequest request) {
        Customer customer = getCustomer(customerId);

        customer.updateData(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.phone(),
                request.address(),
                request.city()
        );

        customerRepository.save(customer);
    }

    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::toCustomerResponse).toList();
    }

    public CustomerResponse getCustomerById(String customerId) {
        return customerMapper.toCustomerResponse(getCustomer(customerId));
    }

    public void deleteCustomerById(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private Customer getCustomer(String customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }
}
