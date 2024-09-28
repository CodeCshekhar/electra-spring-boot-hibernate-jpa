package com.electra.service;

import com.electra.domain.Order;
import com.electra.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Cacheable("getAllOrders")
    public List<Order> getAllOrders() {
        logger.info("Orders Retrieved in Services");
        return orderRepository.findAll();
    }

    @Cacheable("getOrderById")
    public Order getOrderById(Long id) {
        logger.info("Order detected by ID in Services");
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        logger.info("Order Created in Services");
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setProduct(updatedOrder.getProduct());
            order.setCustomer(updatedOrder.getCustomer());
            order.setSupplier(updatedOrder.getSupplier());
            order.setOrderDate(updatedOrder.getOrderDate());
            logger.info("Order Updated in Services");
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        logger.info("Order deleted");
        orderRepository.deleteById(id);
    }

}
