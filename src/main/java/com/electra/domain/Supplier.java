package com.electra.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String contactInfo;
}
