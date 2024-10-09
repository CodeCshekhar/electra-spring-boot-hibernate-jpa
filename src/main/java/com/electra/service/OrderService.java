package com.electra.service;

import com.electra.domain.Order;
import com.electra.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository repo;

    public List<Order> retrieveOrders() {
        logger.info("Inside OrderService.retrieveOrders()");
        return repo.findAll();
    }

    public Order storeOrder(Order order) {
        logger.info("Inside OrderService.storeOrder()");
        return repo.save(order);
    }

    public void deleteOrder(long id) {
        logger.info("Inside OrderService.deleteOrder()");
        repo.deleteById(id);
    }

    public Optional<Order> search(long id) {
        logger.info("Inside OrderService.search()");
        return repo.findById(id);
    }

    public Order updateOrder(Order order) {
        logger.info("Inside OrderService.updateOrder()");
        return repo.save(order);
    }
}
