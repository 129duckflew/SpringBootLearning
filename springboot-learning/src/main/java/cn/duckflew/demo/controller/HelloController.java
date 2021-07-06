package cn.duckflew.demo.controller;

import cn.duckflew.demo.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 主要学习了参数的多种传递方式
 */
@RestController
public class HelloController
{
    @Value("${demo.app.description}")
    private String desc;

    @RequestMapping("/helloWorld")
    public String index()
    {
        return desc;
    }
    @RequestMapping("/test1")
    public Student test1(Integer id,String name)
    {
        Student s=new Student();
        s.setId(id);
        s.setName(name);
        return s;
    }
    @RequestMapping("/test2")
    public Student test2(HttpServletRequest req)
    {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        Student s2=new Student(id,name);
        return s2;
    }
    @RequestMapping("/test3")
    public Student test3(Student student)
    {
        return student;
    }
    @RequestMapping("/test4")
    public Student test4(@RequestParam(value = "stu_id",required = true,defaultValue ="2019000")Integer id,@RequestParam(value = "stu_name",required = false,defaultValue = "默认名字")String name)
    {
        return new Student(id,name);
    }
    @RequestMapping("/test5")
    public Integer[] test5(@RequestParam(value = "ids")Integer[] ids)
    {
        return ids;
    }
    @RequestMapping("/test6")
    public List<Integer> test6(@RequestParam(value = "ids") List<Integer>ids)
    {
        return ids;
    }
    @RequestMapping("/test7/{id}/{name}")
    public Student test7(@PathVariable(value = "id") Integer id,@PathVariable(value = "name")String name)
    {
        return new Student(id,name);
    }
    @RequestMapping(value = "/test8",method = RequestMethod.POST)
    public Map<String,Object>test8(@RequestBody Map<String,Object>map)
    {
        return map;
    }
    @RequestMapping(value = "/test9",method = RequestMethod.POST)
    public List<Student>test9(@RequestBody List<Student> students)
    {
        for (Student student : students)
        {
            System.out.println(student);
        }
        return students;
    }
    @RequestMapping("/test10")
    public String test10(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date date, @NumberFormat(pattern = "#,###.#")BigDecimal price)
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String sDate=sdf.format(date);
        DecimalFormat df=new DecimalFormat("¥#,###.##");
        String sPrice=df.format(price);
        return "今天"+sDate+"的价格是"+sPrice;
    }

}
