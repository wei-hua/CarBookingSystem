package com.alina.carbooking.entity;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author alina
 * @date 2020/8/31
 */
@Data
public class Car {
    private Integer id;
    private String category;
    private String name;
    private Integer stock;
    private BigDecimal price;
    private Integer version;
}
