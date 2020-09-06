package com.alina.carbooking.mapper;

import java.util.List;

import com.alina.carbooking.entity.Order;
import com.alina.carbooking.entity.User;

public interface OrderMapper {
    List<Order> queryAllOrders();
    List<Order> queryOrderByUserId(Long userId);
    int deleteOrder(Long id);
    int addOrder(Order order);
}
