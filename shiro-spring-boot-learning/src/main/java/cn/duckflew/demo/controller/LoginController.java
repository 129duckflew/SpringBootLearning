package cn.duckflew.demo.controller;

import cn.duckflew.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController
{
    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    public String login(String username,String password)
    {
        System.out.println(username);
        System.out.println(password);
        return loginService.login(username,password);
    }
    @PostMapping("/logout")
    public String logout()
    {
      return   loginService.logout();
    }
}
