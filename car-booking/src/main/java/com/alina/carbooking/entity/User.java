package com.alina.carbooking.entity;

import lombok.Data;

@Data
public class User {
    Long id;
    String name;
    String password;
    String phone;
}
