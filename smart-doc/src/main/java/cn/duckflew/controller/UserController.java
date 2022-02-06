package cn.duckflew.controller;

import cn.duckflew.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return user;
    }
}
