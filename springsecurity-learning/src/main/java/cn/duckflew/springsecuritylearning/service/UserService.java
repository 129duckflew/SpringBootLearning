package cn.duckflew.springsecuritylearning.service;

import cn.duckflew.springsecuritylearning.pojo.User;
import cn.duckflew.springsecuritylearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author duckflew
 * @since 2021-03-24
 */
@Service
public class UserService implements UserDetailsService
{

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public boolean selectuserByUsername(String username)
    {
        return userRepository.findByUsername(username)==null;
    }

    public int addNewuser(User User)
    {
        try
        {
            User.setPassword(passwordEncoder.encode(User.getPassword()));
            userRepository.save(User);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }return 1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user=userRepository.findByUsername(username);
        if (user==null)throw new UsernameNotFoundException(username);
        List<GrantedAuthority> authorities=new ArrayList<>();
        return user;
    }
}
