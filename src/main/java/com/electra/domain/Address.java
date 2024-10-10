package com.electra.domain;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity(name = "Address")
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Address {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String street;
    private String city;
    private String state;
    private String country;
    private long postalCode;

    public Address(long id, String street, String city, String state, String country, long postalCode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }
}



