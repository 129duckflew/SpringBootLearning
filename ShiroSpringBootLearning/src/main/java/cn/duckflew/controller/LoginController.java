package cn.duckflew.controller;

import cn.duckflew.entity.RespBean;
import cn.duckflew.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController
{
    @Autowired
    LoginService loginService;
    @PostMapping("/login")
    public RespBean login(String username, String password)
    {
        System.out.println(username);
        System.out.println(password);
        return loginService.login(username,password);
    }
    @PostMapping("/logout")
    public String logout()
    {
      return  loginService.logout();
    }
    @GetMapping("/unauth")
    public String unauth()
    {
        return "未认证  请先登录";
    }
}
