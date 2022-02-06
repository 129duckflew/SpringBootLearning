package cn.duckflew;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class TestAuthentication
{
    public static void main(String[] args)
    {
        DefaultSecurityManager securityManager =new DefaultSecurityManager();
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken xiaochen = new UsernamePasswordToken("xiaochen", "123");
        subject.login(xiaochen);
        System.out.println(subject.isAuthenticated());
    }
}
