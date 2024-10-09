package com.electra.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;
    private String city;
    private String state;
    private String country;

    private long postalCode;
}
