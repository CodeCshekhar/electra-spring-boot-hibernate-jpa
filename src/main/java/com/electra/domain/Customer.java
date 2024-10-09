package com.electra.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL) // Adjust cascade as needed
    @JoinColumn(name = "address_id") // Foreign key for Address
    private Address address;
}
