package com.alina.carbooking.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alina.carbooking.entity.Car;
import com.alina.carbooking.entity.Order;
import com.alina.carbooking.entity.User;
import com.alina.carbooking.service.CarService;
import com.alina.carbooking.service.OrderService;
import com.alina.carbooking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    UserService userService;

    @Resource
    OrderService orderService;

    @Resource
    CarService carService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("/book")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean book(Integer carId,Long userId,HttpServletRequest request,Model model){
        User existUser = userService.queryUserById(userId);
        if (existUser==null){
            logger.error("user does not exist");
            return false;
        }

        Car currentCar = carService.queryCarById(carId);
        if (currentCar == null ||  currentCar.getStock() <= 0) {
            logger.error("this car {} has no stock", carId);
            return false;
        }
        Order order = new Order();
        order.setCarId(carId);
        order.setUserId(userId);
        order.setStartTime(System.currentTimeMillis());
        orderService.createOrder(order);

        currentCar.setStock(currentCar.getStock()-1);
        carService.updateCar(currentCar);
        return true;
    }

    @RequestMapping("/query")
    public String queryOrder(HttpServletRequest request,Model model){
        Long userId = Long.valueOf(request.getParameter("userId"));
        List<Order> orders = orderService.queryOrderByUserId(userId);
        model.addAttribute("userId",userId);
        model.addAttribute("orders", orders);
        return "orders";
    }

    @RequestMapping("/cancel")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean cancel(HttpServletRequest request,Model model){
        Long orderId = Long.valueOf(request.getParameter("orderId"));
        Integer carId = Integer.valueOf(request.getParameter("carId"));

        orderService.deleteOrder(orderId);
        Car currentCar = carService.queryCarById(carId);
        currentCar.setStock(currentCar.getStock()+1);
        carService.updateCar(currentCar);
        return true;
    }
}
