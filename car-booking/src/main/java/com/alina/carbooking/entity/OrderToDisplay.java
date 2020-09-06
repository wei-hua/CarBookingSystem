package com.alina.carbooking.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderToDisplay {
    Long id;
    Long userId;
    Long startTime;
    Long carId;
    String carName;
    BigDecimal price;
}
