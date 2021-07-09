package cn.duckflew.springbootlearning.config;

import cn.duckflew.springbootlearning.realm.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig
{
    /**
     * 拦截所有请求
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager)
    {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //修改默认 认证页面
        shiroFilterFactoryBean.setLoginUrl("/unauth");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
        //页面保护相关信息
        Map<String,String> map=new HashMap<>();
        map.put("/hello","authc");
        map.put("/user/roles","authc");
        map.put("/user/register","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean ;
    }

    /**
     * 安全管理器
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm)
    {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);

        return defaultWebSecurityManager;
    }
    @Primary
    @Bean
    public Realm getRealm()
    {

        CustomerRealm realm = new CustomerRealm();
        /**
         * 配置缓存管理器
         */
        realm.setCacheManager(new EhCacheManager());
        realm.setCachingEnabled(true); //开启全局缓存
        realm.setAuthorizationCachingEnabled(true);  //开启授权缓存
        realm.setAuthorizationCacheName("authorizationCache");  //取名字
        realm.setAuthenticationCachingEnabled(true);  //开启 认证缓存
        realm.setAuthorizationCacheName("authenticationCache");  //取名字
        /**
         * 新建凭证管理器
         */
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher("md5");
        hashedCredentialsMatcher.setHashIterations(1024);   //设置散列次数
        realm.setCredentialsMatcher(hashedCredentialsMatcher);//注入凭证匹配器
        return realm;
    }

}
