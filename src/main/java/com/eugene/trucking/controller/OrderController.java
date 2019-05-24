package com.eugene.trucking.controller;

import com.eugene.trucking.domain.Order;
import com.eugene.trucking.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {

        orderRepo.save(order);
        return order;
    }

    @PutMapping("{id}")
    public Order updateOrder(@PathVariable Long id,
                             @RequestBody Order order) {
        Order orderFromDB = orderRepo.findById(id).get();
        orderFromDB.setOrderNumber(order.getOrderNumber());
        orderFromDB.setDone(order.isDone());
        orderFromDB.setOrderDrivers(order.getOrderDrivers());
        orderFromDB.setRoutePoints(order.getRoutePoints());
        orderFromDB.setTruckForOrder(order.getTruckForOrder());
        return orderFromDB;
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable Long id) {
        Order orderFronDB = orderRepo.findById(id).get();
        orderRepo.delete(orderFronDB);
    }
}
