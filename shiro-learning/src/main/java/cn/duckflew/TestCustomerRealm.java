package cn.duckflew;

import cn.duckflew.realm.CustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;


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
            subject.login(new UsernamePasswordToken("xiaochen","123"));
            System.out.println(subject.isAuthenticated()?"已认证":"未认证");

            System.out.println(subject.hasRole("admin"));
            System.out.println(Arrays.toString(subject.hasRoles(Arrays.asList("admin", "superAdmin"))));
            System.out.println(subject.hasAllRoles(Arrays.asList("admin","superAdmin")));
            System.out.println("用户模块权限"+subject.isPermitted("user:*:01"));
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
