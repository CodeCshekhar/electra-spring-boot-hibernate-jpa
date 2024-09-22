package com.electra.domain;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "supplier")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Supplier {
    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "supplier_name" , nullable = false , unique = true ,updatable = false)
    private String name;

    @Column(name = "contact_details" , nullable = false , unique = true , updatable = false)
    private String contactInfo;
}
