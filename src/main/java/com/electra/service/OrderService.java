package com.electra.service;

import com.electra.model.OrderModel;

import java.util.List;

public interface OrderService {
    OrderModel saveOrder(OrderModel order);
    boolean deleteOrder(final Long orderId);
    List<OrderModel> getAllOrders();
    OrderModel getOrderById(final Long brandId);
}
