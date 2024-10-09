package com.electra.controller;

import com.electra.domain.Order;
import com.electra.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> retrieveOrders() {
        logger.info("Retrieving all orders");
        return ResponseEntity.ok(orderService.retrieveOrders());
    }

    @PostMapping
    public ResponseEntity<Order> storeOrder(@RequestBody Order order) {
        logger.info("Storing order");
        return ResponseEntity.ok(orderService.storeOrder(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable long id) {
        logger.info("Deleting order with id: {}", id);
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> search(@PathVariable long id) {
        logger.info("Searching for order with id: {}", id);
        return ResponseEntity.ok(orderService.search(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable long id, @RequestBody Order order) {
        logger.info("Updating order with id: {}", id);
        return ResponseEntity.ok(orderService.updateOrder(order));
    }
}
