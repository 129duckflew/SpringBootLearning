package cn.duckflew.springbootlearning.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{


    @GetMapping("/hello")
    @RequiresAuthentication
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
