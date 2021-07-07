package cn.duckflew;

import cn.duckflew.realm.CustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;


public class TestCustomerRealm
{
    public static void main(String[] args)
    {
        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        securityManager.setRealm(new CustomerRealm());
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(new UsernamePasswordToken("xiaochen","122342323"));
        }
        catch (UnknownAccountException e)
        {
            System.out.println("用户名错误");
            e.printStackTrace();
        }
        catch (IncorrectCredentialsException e)
        {
            System.out.println("密码错误");
            e.printStackTrace();
        }

    }
}
