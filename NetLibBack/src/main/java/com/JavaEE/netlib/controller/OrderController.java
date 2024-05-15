package com.JavaEE.netlib.controller;

import com.JavaEE.netlib.domain.Order;
import com.JavaEE.netlib.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path="/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "/{id}")
    public Optional<Order> getOrder(@PathVariable Long id) {
        return Optional.ofNullable(orderRepository.findOrderById(id));
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody Order order) throws Exception {
        orderRepository.save(order);
        return "Your order has been placed!";
    }
}
