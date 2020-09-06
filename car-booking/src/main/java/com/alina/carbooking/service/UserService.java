package com.alina.carbooking.service;

import com.alina.carbooking.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author alina
 * @date 2020/8/31
 */
@Component
public interface UserService {
    List<User> queryAllUsers();
    User queryUserById(Long id);
    User queryUserByName(String name);
    int updateUser(User user);
    int deleteUser(Long id);
    int adduser(User user);
}
