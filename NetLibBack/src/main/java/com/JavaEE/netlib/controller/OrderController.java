package com.JavaEE.netlib.controller;

import com.JavaEE.netlib.domain.Order;
import com.JavaEE.netlib.repository.OrderRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = {"/order"}
)
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    public OrderController() {
    }

    @GetMapping(
            path = {"/{id}"}
    )
    public Optional<Order> getOrder(@PathVariable Long id) {
        return Optional.ofNullable(this.orderRepository.findOrderById(id));
    }

    @PostMapping({"/create"})
    public String createOrder(@RequestBody Order order) throws Exception {
        this.orderRepository.save(order);
        return "Your order has been placed!";
    }
}
