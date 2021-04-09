package cn.duckflew.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestActivate
{
    @RequestMapping("/activate/{id}")
    public String activate(@PathVariable(value = "id") Integer id)
    {
        return "激活成功 您的id是"+id;
    }
    @GetMapping("/update")
    @Secured({"ROLE_manager"})
    public String update()
    {
        return "hello update";
    }
    @GetMapping("/preauthorize")
    @PreAuthorize("hasAnyRole('admin')")
    public String preAuthorize()
    {
        return "hello preauthorize";
    }

}
