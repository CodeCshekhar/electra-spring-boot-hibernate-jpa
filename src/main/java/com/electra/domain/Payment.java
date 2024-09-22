package com.electra.domain;

import java.time.LocalDate;
import lombok.*;

import javax.persistence.*;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@Entity
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Payment{

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "amount" , nullable = false , updatable = false)
    private Double amount;

    @Column(name = "payment_date" , nullable = false , updatable = false)
    private LocalDate paymentDate;

    @Column(name = "customer_details" , nullable = false , updatable = false)
    private Customer customer;

    @Column(name =  "order_details" , nullable = false ,updatable = false)
    private Order order;
}
