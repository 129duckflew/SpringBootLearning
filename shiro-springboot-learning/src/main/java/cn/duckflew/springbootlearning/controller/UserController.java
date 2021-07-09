package cn.duckflew.springbootlearning.controller;

import cn.duckflew.springbootlearning.entity.TRole;
import cn.duckflew.springbootlearning.entity.TUser;
import cn.duckflew.springbootlearning.service.TUserService;
import cn.duckflew.springbootlearning.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
       return tUserService.findById(id);
    }

    @GetMapping("/roles")
    public List<TRole> getUserRoles()
    {
        return tUserService.getUserRoles();
    }
}
