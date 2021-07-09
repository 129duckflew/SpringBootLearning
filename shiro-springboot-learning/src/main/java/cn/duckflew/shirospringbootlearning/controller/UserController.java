package cn.duckflew.shirospringbootlearning.controller;

import cn.duckflew.shirospringbootlearning.entity.TRole;
import cn.duckflew.shirospringbootlearning.entity.TUser;
import cn.duckflew.shirospringbootlearning.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
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
        System.out.println(tUser);
       return tUserService.register(tUser);
    }
    @GetMapping("/{id}")
    public TUser getUserById(@PathVariable int id)
    {
       return tUserService.findById(id);
    }
    @GetMapping("/roles/{username}")
    public List<TRole> getUserRoles(@PathVariable String username)
    {
        return tUserService.getUserRoles(username);
    }
}
