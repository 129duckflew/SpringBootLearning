package cn.duckflew;

import cn.duckflew.realm.CustomerMD5Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

public class TestCustomerMD5Realm
{
    public static void main(String[] args)
    {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //新建凭证匹配器
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher("md5");
        hashedCredentialsMatcher.setHashIterations(1024);

        //新建自定义realm
        CustomerMD5Realm customerMD5Realm = new CustomerMD5Realm();
        customerMD5Realm.setCredentialsMatcher(hashedCredentialsMatcher);

        // 设置自定义realm到安全管理器中
        securityManager.setRealm(customerMD5Realm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        //传入用户需要认证的token
        UsernamePasswordToken xiaochen = new UsernamePasswordToken("xiaochen", "123");
        subject.login(xiaochen);//开始认证
    }
}
