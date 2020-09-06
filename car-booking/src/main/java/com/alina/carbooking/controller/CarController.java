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
@RequestMapping("/car")
public class CarController {
    @Resource
    CarService carService;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @RequestMapping("/add")
    @ResponseBody
    public boolean addCar(Car car,HttpServletRequest request){
        carService.addCar(car);
        return true;
    }

    @RequestMapping("/query")
    @ResponseBody
    public List<Car> queryAllCar(HttpServletRequest request){
        return carService.queryAllCars();
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(Car car, HttpServletRequest request){
        carService.updateCar(car);
        return true;
    }
}
