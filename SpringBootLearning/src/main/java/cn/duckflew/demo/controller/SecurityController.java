package cn.duckflew.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController
{
    @RequestMapping("/success")
    public String loginSuccess()
    {
        return "security/success";
    }
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }
    @RequestMapping("/unauthor")
    public String unAuthor403()
    {
        return "unAuthor";
    }
    @ResponseBody
    @RequestMapping("/logouted")
    public String logouted()
    {
        return "您已经登出";
    }
}
