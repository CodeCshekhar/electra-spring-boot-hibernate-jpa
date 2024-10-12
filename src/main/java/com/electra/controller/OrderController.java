package com.electra.controller;

import com.electra.model.OrderModel;
import com.electra.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/electra")
public class OrderController {

    @Resource(name = "orderService")
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderModel> getOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{id}")
    public OrderModel getOrder(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/order")
    public OrderModel saveOrder(final @RequestBody OrderModel orderModel){
        return orderService.saveOrder(orderModel);
    }

    @DeleteMapping("/order/{id}")
    public Boolean deleteOrder(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }
}