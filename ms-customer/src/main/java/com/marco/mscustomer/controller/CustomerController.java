package com.marco.mscustomer.controller;

import com.marco.mscustomer.dto.CustomerRequest;
import com.marco.mscustomer.dto.CustomerResponse;
import com.marco.mscustomer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request, UriComponentsBuilder ucb){
        String id = customerService.createCustomer(request);
        URI location = ucb.cloneBuilder().path("api/v1/customers/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String customerId){
        CustomerResponse customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable String customerId, @RequestBody @Valid CustomerRequest request){
        customerService.updateCustomer(customerId,request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable String customerId){
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.noContent().build();
    }
}
