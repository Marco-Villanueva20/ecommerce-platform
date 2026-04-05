package com.marco.msproduct.entity;

import com.marco.msproduct.exception.ProductException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    @PrePersist
    public void prePersist(){
        if (stock == null){
            stock = 0;
        }
    }

    public Product(String name, String description, BigDecimal price, Integer stock, String imageUrl, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public void update(String name, String description, BigDecimal price, Integer stock, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }

    public void reduceStock(Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new ProductException("The quantity to reduce must be greater than zero.");
        }
        if (this.stock < quantity) {
            throw new ProductException("Insufficient stock for product: " + this.name);
        }
        this.stock -= quantity;
    }

    public void addStock(Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new ProductException("The quantity to add must be greater than zero.");
        }
        // Usamos += para sumar y asignar el nuevo valor
        this.stock += quantity;
    }

}
