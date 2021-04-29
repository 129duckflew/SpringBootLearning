package cn.duckflew.springsecuritylearning.config.security;

import cn.duckflew.springsecuritylearning.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.formLogin()
            .loginPage("/loginPage")
            .loginProcessingUrl("/login")
            .successHandler(new MyAuthenticationSuccessHandler("http://www.baidu.com"))
            .failureForwardUrl("/loginFailPage");
        http.authorizeRequests().antMatchers("/loginPage","/loginFailPage").permitAll();
        http.authorizeRequests().antMatchers("/").authenticated();

        //简单的理解为防火墙    防止跨站请求伪造
        http.csrf().disable();
    }

    @Bean
    PasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
