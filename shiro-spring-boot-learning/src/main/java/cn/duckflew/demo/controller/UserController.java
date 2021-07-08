package cn.duckflew.demo.controller;

import cn.duckflew.demo.entity.TUser;
import cn.duckflew.demo.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    TUserService tUserService;
    @PostMapping("/register")
    public String register(@RequestBody TUser tUser)
    {
        System.out.println(tUser);
       return tUserService.register(tUser);
    }
    @GetMapping("/{id}")
    public TUser getUserById(@PathVariable int id)
    {
       return tUserService.findById(id);
    }
}
