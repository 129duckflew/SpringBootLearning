package cn.duckflew.shirospringbootlearning.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @RequiresRoles("admin")
    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }
    @GetMapping("/index")
    public String index()
    {
        return "官网首页";
    }
}
