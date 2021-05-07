package cn.duckflew.springsecuritylearning.repository;
import cn.duckflew.springsecuritylearning.pojo.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
    Page<Employee> getEmployeeByName(String name, Pageable p);

}
