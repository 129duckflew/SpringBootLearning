package cn.duckflew.springbootlearning.service.impl;

import cn.duckflew.springbootlearning.entity.TRole;
import cn.duckflew.springbootlearning.entity.TUser;
import cn.duckflew.springbootlearning.mapper.TUserMapper;
import cn.duckflew.springbootlearning.service.TUserService;
import cn.duckflew.springbootlearning.util.SaltUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-07-08
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService
{

    @Autowired
    TUserMapper tUserMapper;
    @Override
    public TUser findById(int id)
    {
        return tUserMapper.selectById(id);
    }

    @Override
    public String register(TUser tUser)
    {
        String salt = SaltUtil.getSalt(8);
        Md5Hash md5Hash=new Md5Hash(tUser.getPassword(),salt ,1024);
        tUser.setSalt(salt);
        tUser.setPassword(md5Hash.toHex());
        tUserMapper.insert(tUser);
        return "注册成功";
    }

    @Override
    public List<TRole> getUserRoles()
    {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated())
        {
            PrincipalCollection principals = subject.getPrincipals();
            String username = (String) principals.getPrimaryPrincipal();
            return tUserMapper.selectRolesByUsername(username);
        }
        return null;
    }
}
