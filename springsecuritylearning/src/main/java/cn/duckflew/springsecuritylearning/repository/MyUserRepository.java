package cn.duckflew.springsecuritylearning.repository;


import cn.duckflew.springsecuritylearning.pojo.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser,Integer>
{
    MyUser findByUsername(String username);
}
