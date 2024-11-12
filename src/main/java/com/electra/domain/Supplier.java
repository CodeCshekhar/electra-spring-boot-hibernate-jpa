package com.electra.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity(name = "Supplier")
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Supplier {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    private String contactInfo;

    public Supplier(long id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }
}
