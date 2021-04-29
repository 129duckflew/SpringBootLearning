package cn.duckflew.springsecuritylearning.service;

import cn.duckflew.springsecuritylearning.pojo.MyUser;
import cn.duckflew.springsecuritylearning.repository.UserRepository;
import com.msgf.hr.dao.AdminRepository;
import com.msgf.hr.pojo.Role;
import com.msgf.hr.pojo.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
public class AdminServiceImpl implements UserDetailsService
{

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public boolean selectAdminByUsername(String username)
    {
        return userRepository.findByUsername(username)==null;
    }

    public int addNewAdmin(MyUser myUser)
    {
        try
        {
            myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
            userRepository.save(myUser);
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
        MyUser user=userRepository.findByUsername(username);
        if (admin==null)throw new UsernameNotFoundException(username);
        List<GrantedAuthority> authorities=new ArrayList<>();
        return admin;
    }
}
