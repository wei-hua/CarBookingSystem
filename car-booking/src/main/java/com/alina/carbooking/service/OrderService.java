package com.alina.carbooking.service;

import java.util.List;

import com.alina.carbooking.entity.Order;

public interface OrderService {
    int createOrder(Order order);
    int deleteOrder(Long orderId);
    List<Order> queryAllOrders();
    List<Order> queryOrderByUserId(Long userId);
}
