package cn.duckflew.websocketspringboot.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomerRealm extends AuthorizingRealm
{
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        System.out.println("开始认证");
        String principal= (String) authenticationToken.getPrincipal();
        if (principal.equals("user1"))
            return new SimpleAuthenticationInfo("user1","user1",this.getName());
        else if (principal.equals("user2"))
            return new SimpleAuthenticationInfo("user2","user2",this.getName());
        return null;
    }
}
