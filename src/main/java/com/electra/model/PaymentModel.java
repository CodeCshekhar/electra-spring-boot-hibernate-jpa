package com.electra.model;

import com.electra.domain.Customer;
import com.electra.domain.Order;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentModel {

    private long id;

    private Double amount;

    private LocalDate paymentDate;

    private Customer customer;

    private Order order;
}
