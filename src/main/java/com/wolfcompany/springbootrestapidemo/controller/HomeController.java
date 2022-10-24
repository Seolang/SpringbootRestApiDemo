package com.wolfcompany.springbootrestapidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public Map<String, String> home() {
        Map<String, String> res = new HashMap<>();
        res.put("greet", "hello world");
        return res; // Automatically cast to JSON
    }
}

