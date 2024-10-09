package com.electra.domain;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne // Assuming multiple orders can have the same product
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne // Assuming multiple orders can be made by the same customer
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne // Assuming multiple orders can come from the same supplier
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private LocalDate orderDate;
}
