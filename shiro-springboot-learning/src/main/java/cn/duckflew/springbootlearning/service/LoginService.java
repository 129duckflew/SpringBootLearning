package cn.duckflew.springbootlearning.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class LoginService
{

    public String login(String username, String password)
    {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(usernamePasswordToken);
            return "认证成功"+username;
        } catch (IncorrectCredentialsException e)
        {
            return "密码错误";
        }
        catch (UnknownAccountException e)
        {
            return "用户名错误";
        }
    }

    public String logout()
    {

        SecurityUtils.getSubject().logout();
        return "退出成功";
    }
}
