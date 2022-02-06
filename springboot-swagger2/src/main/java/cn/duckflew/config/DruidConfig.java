package cn.duckflew.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig
{
    @ConfigurationProperties(prefix ="spring.datasource")
    @Bean
    public DataSource dataSource()
    {
        return new DruidDataSource();
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean()
    {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //账号密码
        Map<String,String> map=new HashMap<>();;
        map.put("loginUsername","duckflew");
        map.put("loginPassword","123456");
        map.put("allow","");
        bean.setInitParameters(map);
        return bean;
    }
}
