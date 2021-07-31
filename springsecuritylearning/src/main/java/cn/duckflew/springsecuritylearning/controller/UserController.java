package cn.duckflew.springsecuritylearning.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController
{
    @PreAuthorize("hasRole('ROLE_DB')")
    @RequestMapping("/loginPage")
    public String login()
    {
        return "loginPage";
    }
    @RequestMapping("/login")
    public String loginSuccessful()
    {
        return "success";
    }
    @RequestMapping("/loginFailPage")
    public String loginFail()
    {
        return "loginFail";
    }
}
