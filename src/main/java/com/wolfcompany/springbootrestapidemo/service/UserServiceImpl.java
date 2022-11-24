package com.wolfcompany.springbootrestapidemo.service;

import com.wolfcompany.springbootrestapidemo.dao.UserRepository;
import com.wolfcompany.springbootrestapidemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, String> getMessage() {
        Map<String, String> res = new HashMap<>();
        res.put("greet", "Hello World");

        return res;
    }

    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserById(Integer userid) {
        return userRepository.getUserByUserid(userid);
    }

    public User registUser(User user) {
        return userRepository.insertUser(user);
    }

    public void modifyUser(Integer userid, User user) {
        user.setUserid(userid);
        userRepository.updateUser(user);
    }

    public void removeUser(Integer userid) {
        userRepository.deleteUser(userid);
    }

}
