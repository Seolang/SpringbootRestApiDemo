package com.wolfcompany.springbootrestapidemo.service;

import com.wolfcompany.springbootrestapidemo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTests {

    @Autowired
    private UserServiceImpl userService;

    // Controller는 Junit 뿐만아닌 Postman등의 통신 테스트를 통해서도 확인이 가능
    @Test
    public void testRegistUser() {
        User user = new User(1000, "kkkim");
        User rst = userService.registUser(user);

        Assert.assertEquals(user, rst);

    }
}
