package cn.duckflew.springsecuritylearning.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/basic")
public class EmployeeBasicController
{
    @Autowired
    EmployeeServiceImpl employeeService;

    @RequestMapping("/hello")
    public String hello()
    {
        return "hello";
    }
    @GetMapping("/")
    public Page<Employee> getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size)
    {
        System.out.println(page+" "+size);
        return employeeService.getEmployeeByPage(page,size);
    }

    /**
     * 根据姓名 分页查询员工信息
     * @param page
     * @param size
     * @param name
     * @return
     */
    @GetMapping("/byname/{name}")
    public Page<Employee> getEmployeeByEmpNameAndPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, @PathVariable String name)
    {
        System.out.println(page+" "+size);
        return employeeService.getEmpByEmpName(page,size,name);
    }
    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee)
    {
        if (1==employeeService.addEmp(employee))
        {
           return  RespBean.success("添加成功");
        }
       return  RespBean.error("添加失败");
    }
    @DeleteMapping("/{id}")
    public RespBean deleteEmpById(@PathVariable Integer id)
    {
        if (1==employeeService.deleteEmpById(id))
            return RespBean.success("删除成功");
        return RespBean.error("删除失败");
    }
    @PutMapping("/")
    public RespBean updateEmpById(@RequestBody Employee employee)
    {
        if (1==employeeService.updateEmp(employee))return RespBean.success("更新成功！");
        return RespBean.error("更新失败");
    }
    @GetMapping("/{id}")
    public RespBean getEmpById(@PathVariable Integer id)
    {
        Employee empById = employeeService.getEmpById(id);
        if (empById!=null)
        {
            return RespBean.success("查询成功", empById);
        }
        return RespBean.error("未找到");
    }
}
