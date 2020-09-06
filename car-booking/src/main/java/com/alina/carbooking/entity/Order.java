package com.alina.carbooking.entity;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Order {
    Long id;
    Integer carId;
    Long userId;
    Long startTime;
}
