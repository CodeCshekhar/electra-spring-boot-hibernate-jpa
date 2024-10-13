package com.electra.model;

import com.electra.domain.Customer;
import com.electra.domain.Product;
import com.electra.domain.Supplier;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderModel {

    private long id;

    private Product product;

    private Customer customer;

    private Supplier supplier;

    private LocalDate orderDate;
}
