package cn.duckflew.demo.controller;

import cn.duckflew.demo.entity.User;
import cn.duckflew.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;


@Controller
public class UserController
{
    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public String index()
    {
        return "redirect:/list";
    }
    @RequestMapping("/list")
    public String list(Model model)
    {
        model.addAttribute("users",userService.getUserList());
        return "user/list";
    }
    @RequestMapping("/add")
    public String add()
    {
       return "user/add";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(User user)
    {
        user.setRegdate(new Date());
        user.setStatus(0);
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable long id)
    {
        User userForEdit = userService.findUserById(id);
        model.addAttribute("user" ,userForEdit);
        return "user/edit";
    }
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(User user)
    {
        userService.save(user);
        return "redirect:/list";
    }
    @RequestMapping("/delete/{id}")
    public String delete(Model model ,@PathVariable long id)
    {
        model.addAttribute("user",userService.findUserById(id));
        return "user/delete";
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public String delete(@PathVariable long id)
    {
        userService.delete(id);
        return "redirect:/list";
    }


}
