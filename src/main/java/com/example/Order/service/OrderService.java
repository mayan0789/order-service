package com.example.Order.service;

import java.util.List;
import com.example.Order.entity.Order;

public interface OrderService {

    Order createOrder(Order order);

    Order getOrder(Long id);

    List<Order> getAllOrders();

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);
}