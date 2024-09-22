package com.electra.domain;

import lombok.*;

import javax.persistence.*;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {
    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name" , nullable = false)
    private String name;

    @Column(name = "product_description" , nullable = false)
    private String description;

    @Column(name = "product_price" , nullable = false , updatable = false)
    private Double price;

    @Column(name = "brand_details" , nullable = false)
    private Brand brand;
}
