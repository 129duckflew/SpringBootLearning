package cn.duckflew.demo.service.impl;

import cn.duckflew.demo.entity.TUser;
import cn.duckflew.demo.mapper.TUserMapper;
import cn.duckflew.demo.service.TUserService;
import cn.duckflew.demo.util.SaltUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
