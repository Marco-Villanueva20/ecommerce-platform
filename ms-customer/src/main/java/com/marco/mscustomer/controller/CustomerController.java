package com.marco.mscustomer.controller;

import com.marco.mscustomer.dto.CustomerRequest;
import com.marco.mscustomer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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

}
