package com.june.controller;

import com.june.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private User user;

    @GetMapping("hi")
    public String hello() {
        return "hello";
    }

    @GetMapping("hh")
    public String userList() {
       return user.toString();
    }

}
