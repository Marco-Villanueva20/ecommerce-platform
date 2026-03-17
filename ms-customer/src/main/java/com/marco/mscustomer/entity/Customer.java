package com.marco.mscustomer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document
public class Customer {

    @Id
    String id;
    String firstName;
    String lastName;
    String email;
    String phone;
    String address;
    String city;
}
