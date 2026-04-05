package com.marco.msproduct.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;


    /* Mapped by define al propietario quien tendrá el foránea */
    @OneToMany(mappedBy = "category",  fetch = FetchType.LAZY)
    private List<Product> products;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void update(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Category(Long id) {
        this.id = id;
    }
}
