package com.electra.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity(name = "Brand")
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Brand {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    public Brand(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
