package cn.duckflew.shirospringbootlearning.config;

import cn.duckflew.shirospringbootlearning.realm.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //页面保护相关信息
        Map<String,String> map=new HashMap<>();
        map.put("/hello","authc");
        map.put("/user/*","anon");
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
         * 新建凭证管理器
         */
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher("md5");
        hashedCredentialsMatcher.setHashIterations(1024);   //设置散列次数
        realm.setCredentialsMatcher(hashedCredentialsMatcher);//注入凭证匹配器
        return realm;
    }

}
