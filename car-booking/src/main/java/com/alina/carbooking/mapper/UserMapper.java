package com.alina.carbooking.mapper;

import java.util.List;

import com.alina.carbooking.entity.User;

public interface UserMapper {
    List<User> queryAllUsers();
    User queryUserById(Long id);
    User queryUserByName(String name);
    int updateUser(User user);
    int deleteUser(Long id);
    int addUser(User user);
}
