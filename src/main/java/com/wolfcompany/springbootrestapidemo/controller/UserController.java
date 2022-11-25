package com.wolfcompany.springbootrestapidemo.controller;

import com.wolfcompany.springbootrestapidemo.annotation.TokenRequired;
import com.wolfcompany.springbootrestapidemo.model.User;
import com.wolfcompany.springbootrestapidemo.service.UserService;
import com.wolfcompany.springbootrestapidemo.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    @TokenRequired
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userid}")
    public User getUserByUserid(@PathVariable Integer userid) { // 이름이 같으면 PathVariable에 별도의 네이밍 필요 X

        return userService.getUserById(userid);
    }

    @PostMapping("")
    public User registUser(@RequestBody User user) {    // 객체와 JSON 형식이 같다면 자동 매핑
        return userService.registUser(user);
    }

    @PutMapping("/{userid}")  // -> 추가 url이 없어도 되지만, key값을 주는것이 좋다
    public void modifyUser(@PathVariable Integer userid,
                           @RequestBody User user) {
        logger.debug(""+userid);
        userService.modifyUser(userid, user);
    }

    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable Integer userid) {
        userService.removeUser(userid);
    }

}
