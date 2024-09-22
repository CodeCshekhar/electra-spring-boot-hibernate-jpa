package com.electra.domain;

import lombok.*;
import javax.persistence.*;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@Entity
@Table(name = "brand")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Brand {
    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "description" , nullable = false)
    private String description;
}
