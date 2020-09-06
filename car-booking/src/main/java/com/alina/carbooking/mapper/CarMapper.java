package com.alina.carbooking.mapper;

import java.util.List;

import com.alina.carbooking.entity.Car;

public interface CarMapper {
    List<Car> queryAllCars();
    Car queryCarById(Integer id);
    int updateCar(Car car);
    int addCar(Car car);
}
