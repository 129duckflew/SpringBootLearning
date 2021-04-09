package cn.duckflew.demo.controller;

import cn.duckflew.demo.entity.User;
import cn.duckflew.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController
{
    @Autowired
    private UserService userService;
    @RequestMapping("/get/{id}")
    public User test(@PathVariable long id)
    {
        return userService.findUserById(id);
    }
    @RequestMapping("/getall")
    public List<User>test()
    {
        return userService.getUserList();
    }
    @RequestMapping("/login")
    public User login(@RequestParam String username,@RequestParam String password)
    {
        return userService.login(username,password);
    }
}
