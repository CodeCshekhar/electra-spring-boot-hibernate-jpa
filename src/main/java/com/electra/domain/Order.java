package com.electra.domain;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity(name = "Order")
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Order {
    @Id
    @ToString.Exclude
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private Product product;

    private Customer customer;

    private Supplier supplier;

    private LocalDate orderDate;

    public Order(long id, Product product, Customer customer, Supplier supplier, LocalDate orderDate) {
        this.id = id;
        this.product = product;
        this.customer = customer;
        this.supplier = supplier;
        this.orderDate = orderDate;
    }
}
