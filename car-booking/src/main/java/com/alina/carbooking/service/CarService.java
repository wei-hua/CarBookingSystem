package com.alina.carbooking.service;

import com.alina.carbooking.entity.Car;

import java.util.List;

/**
 * @author alina
 * @date 2020/8/31
 */
public interface CarService {
    List<Car> queryAllCars();
    Car queryCarById(Integer id);
    int updateCar(Car car);
    int addCar(Car car);
}
