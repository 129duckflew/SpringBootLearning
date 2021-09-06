package cn.duckflew.springsecuritylearning.service;

import cn.duckflew.springsecuritylearning.pojo.Employee;
import cn.duckflew.springsecuritylearning.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;


@Service
public class EmployeeServiceImpl
{
    @Autowired
    EmployeeRepository employeeRepository;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    public Page<Employee> getEmployeeByPage(Integer page, Integer size)
    {
        System.out.println(page  +" "+ size);
        PageRequest pr =PageRequest.of(page-1,size);
        Page<Employee> employees=employeeRepository.findAll(pr);
        return employees;
    }

    public int addEmp(Employee employee)
    {
        employeeRepository.save(employee);
        return 1;
    }

    public int deleteEmpById(Integer id)
    {
        try
        {
            employeeRepository.deleteById(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public int updateEmp(Employee employee)
    {
        try
        {
            employeeRepository.save(employee);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public Employee getEmpById(Integer id)
    {
        Employee employee=null;
        try
        {
            employee = employeeRepository.findById(id).get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return employee;
    }

    public Page<Employee> getEmpByEmpName(Integer page, Integer size, String empName)
    {
        System.out.println(page  +" "+ size);
        PageRequest pr =PageRequest.of(page-1,size);
        Page<Employee> employees=employeeRepository.getEmployeeByName(empName,pr);
        return employees;
    }
}
