package cn.duckflew.demo.service.UserServiceImpl;

import cn.duckflew.demo.entity.User;
import cn.duckflew.demo.repository.UserRepository;
import cn.duckflew.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService
{

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getUserList()
    {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id)
    {
        return userRepository.findById(id).get();
    }

    @Override
    public void save(User user)
    {
        userRepository.save(user);
    }

    @Override
    public void edit(User user)
    {
        userRepository.save(user);
    }

    @Override
    public void delete(long id)
    {
        userRepository.deleteById(id);
    }

    @Override
    public User login(String username, String password)
    {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public User getUserByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

}
