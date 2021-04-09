package cn.duckflew.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        List<GrantedAuthority> auths= AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_admin");
        cn.duckflew.demo.entity.User checkUser = userService.getUserByUsername(s);
        if (checkUser==null)
        {
            /**
             * 认证失败
             */
            throw new UsernameNotFoundException("用户名"+s+"不存在");
        }
        else
        {
            return new User(s,new BCryptPasswordEncoder().encode(checkUser.getPassword()),auths);
        }
    }
}
