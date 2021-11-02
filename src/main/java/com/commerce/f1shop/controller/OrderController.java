package com.commerce.f1shop.controller;

import com.commerce.f1shop.db.OrderRepository;
import com.commerce.f1shop.exeptions.DoesNotExistException;
import com.commerce.f1shop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RequestMapping(path = "orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long orderId) throws IOException {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new DoesNotExistException(orderId));
        return ResponseEntity.ok().body(order);
    }

    @GetMapping("/user/{id}")
    public List<Order> getOrdersByUserId(@PathVariable Long id) {
        return orderRepository.findByUserId(id);
    }

    @PostMapping("/")
    public void createOrder(@RequestBody Order order) throws IOException {
        orderRepository.save(order);
    }

    @DeleteMapping("/{id}")
    public Order deleteOrder(@PathVariable("id") long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new DoesNotExistException(id));
        orderRepository.deleteById(id);
        return order;
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") long id, @RequestBody Order newOrder) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new DoesNotExistException(id));
        orderRepository.deleteById(id);
        newOrder.setId(id);
        orderRepository.save(newOrder);
        return newOrder;
    }
}
