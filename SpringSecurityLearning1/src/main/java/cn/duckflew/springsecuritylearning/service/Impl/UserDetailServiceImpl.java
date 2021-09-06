package cn.duckflew.springsecuritylearning.service.Impl;

import cn.duckflew.springsecuritylearning.pojo.MyUser;
import cn.duckflew.springsecuritylearning.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService
{
    @Autowired
    MyUserRepository myUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username)
    {
        MyUser myUser = myUserRepository.findByUsername(username);
        if (myUser==null)throw new UsernameNotFoundException("用户名未找到") ;

        System.out.println("登录成功");
        return new User(username,myUser.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal,ROLE_DB"));
    }
}
