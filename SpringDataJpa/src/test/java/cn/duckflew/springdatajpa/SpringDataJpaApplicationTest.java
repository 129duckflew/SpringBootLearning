package cn.duckflew.springdatajpa;

import cn.duckflew.springdatajpa.entity.Employee;
import cn.duckflew.springdatajpa.repository.EmpRepositorySpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringDataJpaApplicationTest
{

    @Autowired
    EmpRepositorySpecification empRepositorySpecification;
    @Test
    void contextLoads()
    {

    }

    /**
     * 单条件测试
     */
    @Test
    void oneCondition()
    {
        Specification<Employee> spec=new Specification<Employee>()
        {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb)
            {
                /**
                 * root  是对查询对象的属性的封装
                 * query 封装要执行的查询中各个部分的信息  select order from by 这些
                 * CriteriaBuilder 查询条件的构造器
                 */
                //封装一个查询条件
                return cb.equal(root.get("id"),"3");
            }
        };
        List<Employee> employeeList = this.empRepositorySpecification.findAll(spec);
        for (Employee employee : employeeList)
        {
            System.out.println(employee);
        }
    }

    /**
     * 多条件查询
     */
    @Test
    void multipleCondition()
    {
        Specification<Employee> spec=new Specification<Employee>()
        {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb)
            {
                /**
                 * root  是对查询对象的属性的封装
                 * query 封装要执行的查询中各个部分的信息  select order from by 这些
                 * CriteriaBuilder 查询条件的构造器
                 *
                 */
                //封装多个查询条件
                List<Predicate> list=new ArrayList<>();
                Predicate id = cb.equal(root.get("id"), "3");
                Predicate gender = cb.equal(root.get("gender"), "男");
                list.add(id);
                list.add(gender);
                Predicate[] predicates=new Predicate[list.size()];
                return cb.or(list.toArray(predicates));
            }
        };
        List<Employee> employeeList = this.empRepositorySpecification.findAll(spec);
        for (Employee employee : employeeList)
        {
            System.out.println(employee);
        }
    }


}
