package com.alina.carbooking.service;

import java.util.List;

import javax.annotation.Resource;

import com.alina.carbooking.entity.Car;
import com.alina.carbooking.mapper.CarMapper;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    @Resource
    CarMapper carMapper;

    @Override
    public List<Car> queryAllCars() {
        return carMapper.queryAllCars();
    }

    @Override
    public Car queryCarById(Integer id) {
        return carMapper.queryCarById(id);
    }

    @Override
    public int updateCar(Car car) {
        return carMapper.updateCar(car);
    }

    @Override
    public int addCar(Car car) {
        return carMapper.addCar(car);
    }
}
