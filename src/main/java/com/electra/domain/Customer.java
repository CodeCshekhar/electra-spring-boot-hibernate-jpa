package com.electra.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity(name = "Customer")
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Customer {
    @Id
    @ToString.Exclude
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    @ToString.Exclude
    private String email;

    private Address address;

    public Customer(long id, String name, String email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
