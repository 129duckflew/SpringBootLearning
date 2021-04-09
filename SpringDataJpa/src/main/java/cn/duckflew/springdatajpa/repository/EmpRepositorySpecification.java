package cn.duckflew.springdatajpa.repository;

import cn.duckflew.springdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmpRepositorySpecification extends JpaRepository<Employee,Integer>,JpaSpecificationExecutor<Employee>
{

}
