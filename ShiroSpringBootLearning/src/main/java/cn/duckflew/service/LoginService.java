package cn.duckflew.service;

import cn.duckflew.entity.RespBean;
import cn.duckflew.entity.TUser;
import cn.duckflew.util.JwtUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService
{
    @Autowired
    TUserService tUserService;
    public RespBean login(String username, String password)
    {
        TUser user = tUserService.getOne(Wrappers.<TUser>lambdaQuery().eq(TUser::getUsername, username));
        if (user==null) return RespBean.error("用户名错误");
        Md5Hash md5Hash=new Md5Hash(password,user.getSalt(),1024);
        System.out.println(md5Hash.toHex());
        System.out.println(user.getPassword());
        if (md5Hash.toHex().equals(user.getPassword()))
        {
            Map<String,String> map=new HashMap<>();
            map.put("username",username);
            map.put("userId",user.getId().toString());
            String token = JwtUtil.getToken(map);
            map.put("token",token);
            return RespBean.success("身份验证通过", map);
        }
        return RespBean.error("密码错误");
    }

    public String logout()
    {
        SecurityUtils.getSubject().logout();
        return "退出成功";
    }
}
