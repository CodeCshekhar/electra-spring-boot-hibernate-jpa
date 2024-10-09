package com.electra.domain;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Double amount;
    private LocalDate paymentDate;

    @ManyToOne // Assuming multiple payments can be made by the same customer
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne // Assuming multiple payments can be related to the same order
    @JoinColumn(name = "order_id")
    private Order order;
}
