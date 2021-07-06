package cn.duckflew.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebJarsController
{
    @RequestMapping("/webjars/index")
    public String index()
    {
        return "/webJars/index";
    }
    @RequestMapping("/webjars/layout")
    public String layout()
    {
        return "/common/layout";
    }
}
