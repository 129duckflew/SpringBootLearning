package cn.duckflew.demo.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

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
        String principal = (String) authenticationToken.getPrincipal();
        if (principal.equals("xiaochen"))
        {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("xiaochen", "9c074aff230a802bf52901cddd5c81da", ByteSource.Util.bytes("salt"), this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
