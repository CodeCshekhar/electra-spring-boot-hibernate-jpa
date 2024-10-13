package com.electra.domain;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity(name = "Payment")
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Payment{

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private Double amount;

    private LocalDate paymentDate;

    private Customer customer;

    private Order order;

    public Payment(long id, Double amount, LocalDate paymentDate, Customer customer, Order order) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.customer = customer;
        this.order = order;
    }
}
