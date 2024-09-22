package com.electra.domain;

import lombok.*;
import javax.persistence.*;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "email" , nullable = false , unique = true)
    private String email;

    @Column(name = "address" , nullable = false )
    private Address address;
}
