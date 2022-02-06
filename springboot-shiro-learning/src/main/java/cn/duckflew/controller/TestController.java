package cn.duckflew.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/test")
public class TestController
{
    @GetMapping("/")
    public String test()
    {
        return "测试打包";
    }
}
