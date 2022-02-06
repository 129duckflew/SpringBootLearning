package cn.duckflew.realm;

import cn.duckflew.entity.TRole;
import cn.duckflew.entity.TUser;
import cn.duckflew.mapper.TUserMapper;
import cn.duckflew.service.TUserService;
import cn.duckflew.token.JwtToken;
import cn.duckflew.util.JwtUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerRealm extends AuthorizingRealm
{
    @Autowired
    TUserService userService;

    @Override
    public boolean supports(AuthenticationToken token)
    {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {

        System.out.println("进入授权");
        String username= JwtUtil.getUsernameFromToken(principalCollection.toString());
        TUser user = userService.getOne(Wrappers.<TUser>lambdaQuery().eq(TUser::getUsername, username), false);

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        List<TRole> userRoles = userService.getUserRolesByUsername(user.getUsername());
        for (TRole userRole : userRoles)
        {
            simpleAuthorizationInfo.addRole(userRole.getName());
        }
        return simpleAuthorizationInfo;
    }

    @Autowired
    TUserMapper userMapper;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        String token = (String) authenticationToken.getPrincipal();
        String username=JwtUtil.getUsernameFromToken(token);
        if (username==null)
        {
            throw new UnauthenticatedException("token 无效");
        }
        return new SimpleAuthenticationInfo(token,token, this.getName());
    }
}
