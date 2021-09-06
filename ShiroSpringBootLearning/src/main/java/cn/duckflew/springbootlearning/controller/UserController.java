package cn.duckflew.springbootlearning.controller;

import cn.duckflew.springbootlearning.entity.TUser;
import cn.duckflew.springbootlearning.service.TUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
       return tUserService.register(tUser);
    }
    @GetMapping("/{id}")
    public TUser getUserById(@PathVariable int id)
    {
       return tUserService.getOne(Wrappers.<TUser>lambdaQuery().eq(TUser::getId,id));
    }
}
