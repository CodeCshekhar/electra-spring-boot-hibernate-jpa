package com.electra.domain;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer; // Link back to Customer
}
