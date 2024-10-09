package com.electra.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private Double price;

    @ManyToOne // Assuming a product can belong to one brand
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
