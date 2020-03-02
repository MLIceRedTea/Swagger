package com.example.swagerdemo.controller;

import com.example.swagerdemo.Pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiOperation("接口中文注销析")
public class HelloContoller {
    @GetMapping(value = "/hello")
    public String send(){
        return "hello";
    }
    @PostMapping(value = "/hi")
    public User hi(User user){
        User user1 = new User();
        user1.setName("app");
        user1.setPassword("add");
        return user1;
    }
}
