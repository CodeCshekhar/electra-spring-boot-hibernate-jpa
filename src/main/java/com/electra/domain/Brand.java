package com.electra.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "Brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
}
