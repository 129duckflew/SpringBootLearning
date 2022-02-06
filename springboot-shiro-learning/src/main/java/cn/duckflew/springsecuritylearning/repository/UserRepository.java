package cn.duckflew.springsecuritylearning.repository;


import cn.duckflew.springsecuritylearning.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>
{
    User findByUsername(String username);
}
