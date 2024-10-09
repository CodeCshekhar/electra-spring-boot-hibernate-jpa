package com.electra.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
