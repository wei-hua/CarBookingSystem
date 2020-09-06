package com.alina.carbooking.service;

import java.util.List;

import com.alina.carbooking.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getLearn(){
        List<User> users =userService.queryAllUsers();
        Assert.assertEquals(1,users.size());
        System.out.println(users);
    }
}
