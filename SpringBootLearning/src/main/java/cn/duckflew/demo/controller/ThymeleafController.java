package cn.duckflew.demo.controller;

import cn.duckflew.demo.entity.Student;
import org.omg.PortableServer.AdapterActivator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController
{
    @RequestMapping("/th")
    public String index(Model model)
    {
        String msg="this is a thymeleaf msg from houduan to thymeleaf";
        model.addAttribute("msg",msg);
        return "th/index";
    }
    /**
     * model 的另一种用法
     */
    @RequestMapping("/index1")
    ModelAndView index1()
    {
        String msg="this is a thymeleaf msg from houduan to thymeleaf";
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("th/index");
        return modelAndView;
    }
    /**
     * thymeleaf 常用表达式的基本用法
     */
    @RequestMapping("/index2")
    public String index2(Model model)
    {
        model.addAttribute("stu",new Student(2,"thymeleafsadasd"));
        model.addAttribute("hrefMsg","图片点击这里看");
        model.addAttribute("flag",true);
        List<String>strings=new ArrayList<>();
        strings.add("aaaaaa");
        strings.add("bbbbbbb");
        strings.add("ccccccc");
        model.addAttribute("strings",strings);
        return "th/index2";
    }
    /**
     * 遍历对象集合
     */
    @RequestMapping("/index3")
    public String index3(Model model)
    {
        List<Student>students=new ArrayList<>();
        students.add(new Student(20101222,"小明"));
        students.add(new Student(9874563,"小华"));
        students.add(new Student(46512346,"小芳"));
        model.addAttribute("students",students);
        return "th/index3";
    }
}
