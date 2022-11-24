package com.wolfcompany.springbootrestapidemo.service;

import com.wolfcompany.springbootrestapidemo.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, String> getMessage();
    List<User> getUsers();

    User getUserById(Integer userid);

    User registUser(User user);

    void modifyUser(Integer userid, User user);

    void removeUser(Integer userid);
}
