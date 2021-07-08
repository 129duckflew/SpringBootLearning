package cn.duckflew.demo.controller;

import cn.duckflew.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    UserService userService;
    @PostMapping("/register")
    public String register(String username,String password)
    {

        return userService.register(username,password);
    }
}
