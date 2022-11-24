package com.wolfcompany.springbootrestapidemo.controller;

import com.wolfcompany.springbootrestapidemo.service.SecurityService;
import com.wolfcompany.springbootrestapidemo.service.SecurityServiceImpl;
import com.wolfcompany.springbootrestapidemo.service.UserService;
import com.wolfcompany.springbootrestapidemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController // @Controller + @ResponseBody
@RequestMapping("/")   // End point http://localhost:8080/
public class HomeController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private SecurityServiceImpl securityService;

    @GetMapping("") //home
    public Map<String, String> home() {
        Map<String, String> res = this.userService.getMessage();

        return res; // Automatically cast to JSON
    }

    // 토큰 발행
    @GetMapping("security/generate/token")
    public Map<String, Object> generateToken(@RequestParam String subject) {
        String token = securityService.createToken(subject, 1000*60*60);
        Map<String, Object> map = new HashMap<>();
        map.put("userid", subject);
        map.put("token", token);
        return map;
    }

    // 토큰 요청
    @GetMapping("security/get/subject")
    public String getSubject(@RequestParam String token) {
        String subject = securityService.getSubject(token);
        return subject;
    }



}

