package cn.duckflew.realm;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomerRealm extends AuthorizingRealm
{
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        /**
         * 根据身份   也就是用户名 查询到权限信息
         */
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("admin");
        simpleAuthorizationInfo.addStringPermission("user:*:*");
        return simpleAuthorizationInfo ;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        String principal = (String) authenticationToken.getPrincipal();
        if ("xiaochen".equals(principal))
        {
            SimpleAuthenticationInfo  simpleAuthenticationInfo=new SimpleAuthenticationInfo("xiaochen","123",this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
