package cn.duckflew.demo.service;

import cn.duckflew.demo.entity.User;

import java.util.List;

public interface UserService
{
     List<User>getUserList();
     User findUserById(long id);
     void save(User user);
     void edit(User user);
     void delete(long id);
     User login(String username,String password);
     User getUserByUsername(String  username);
}
