package com.electra.domain;


import java.time.LocalDate;
import lombok.*;
import javax.persistence.*;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@Entity
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Order {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product" , nullable = false , unique = true , updatable = false)
    private Product product;

    @Column(name = "customer_details" , nullable = false , unique = true , updatable = false)
    private Customer customer;

    @Column(name = "supplier_details" , nullable = false , unique = true , updatable = false )
    private Supplier supplier;

    @Column(name = "order_date" , nullable = false , updatable = false)
    private LocalDate orderDate;
}
