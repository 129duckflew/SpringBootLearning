package cn.duckflew.shirospringbootlearning.realm;

import cn.duckflew.shirospringbootlearning.entity.TRole;
import cn.duckflew.shirospringbootlearning.entity.TUser;
import cn.duckflew.shirospringbootlearning.mapper.TUserMapper;
import cn.duckflew.shirospringbootlearning.service.TUserService;
import cn.duckflew.shirospringbootlearning.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerRealm extends AuthorizingRealm
{
    @Autowired
    TUserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        List<TRole> userRoles = userService.getUserRoles(username);
        if (userRoles!=null)
        {
            for (TRole userRole : userRoles)
            {
                simpleAuthorizationInfo.addRole(userRole.getName());
            }
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Autowired
    TUserMapper userMapper;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        System.out.println("开始认证");
        String principal = (String) authenticationToken.getPrincipal();
        TUser user= userMapper.selectByUsername(principal);
        if (user!=null)
        {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal,user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
