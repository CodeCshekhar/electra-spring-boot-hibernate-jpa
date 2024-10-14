package com.electra.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity(name = "Product")
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private Double price;

    private Brand brand;

    public Product(long id, String name, String description, Double price, Brand brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.brand = brand;
    }
}
