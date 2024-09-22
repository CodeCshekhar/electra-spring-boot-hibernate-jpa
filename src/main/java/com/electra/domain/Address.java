package com.electra.domain;

import lombok.*;
import javax.persistence.*;

@Builder
@Data  // Lombok annotation to generate getters, setters, toString, etc.
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name ="address")

public class Address {
    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street" , nullable = false)
    private String street;

    @Column(name = "city" , nullable = false)
    private String city;

    @Column(name = "state" , nullable = false)
    private String state;

    @Column(name = "country" , nullable = false)
    private String country;

    @Column(name = "postal_code" , nullable = false)
    private long postalCode;
}



