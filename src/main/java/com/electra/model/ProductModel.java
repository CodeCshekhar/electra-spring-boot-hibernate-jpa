package com.electra.model;

import com.electra.domain.Brand;
import lombok.Data;

@Data
public class ProductModel {

    private long id;

    private String name;

    private String description;

    private Double price;

    private Brand brand;
}
