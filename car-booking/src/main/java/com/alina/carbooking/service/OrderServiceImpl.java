package com.alina.carbooking.service;

import java.util.List;

import javax.annotation.Resource;

import com.alina.carbooking.entity.Order;
import com.alina.carbooking.entity.User;
import com.alina.carbooking.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author alina
 * @date 2020/8/31
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Resource
    OrderMapper orderMapper;

    @Override
    public int createOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int deleteOrder(Long orderId) {
        return orderMapper.deleteOrder(orderId);
    }

    @Override
    public List<Order> queryAllOrders() {
        return orderMapper.queryAllOrders();
    }

    @Override
    public List<Order> queryOrderByUserId(Long userId) {
        return orderMapper.queryOrderByUserId(userId);
    }
}
