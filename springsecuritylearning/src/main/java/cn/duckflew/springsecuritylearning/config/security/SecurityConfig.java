package cn.duckflew.springsecuritylearning.config.security;
import cn.duckflew.springsecuritylearning.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        super.configure(auth);
    }
    @Autowired
    UserService userService;
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.formLogin()
                .loginProcessingUrl("/login")
                .successHandler((req, response, authentication) ->
                {
                    Object principal = authentication.getPrincipal();
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    Map<String,Object> map=new HashMap<>();
                    map.put("status",200);
                    map.put("msg",principal);
                    ObjectMapper om= new ObjectMapper();
                    out.write(om.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .failureHandler((req, response, e) ->
                {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(401);
                    PrintWriter out = response.getWriter();
                    Map<String,Object> map=new HashMap<>();
                    map.put("status",401);
                    if (e instanceof LockedException)
                    {
                        e.printStackTrace();
                        map.put("msg","账户被锁定,登录失败");
                    }
                    else if (e instanceof BadCredentialsException)map.put("msg","用户名或密码错误,登录失败");
                    else if (e instanceof AccountExpiredException)map.put("msg","账户过期,登录失败");
                    else if (e instanceof DisabledException)map.put("msg","账户禁用,登录失败");
                    else if (e instanceof CredentialsExpiredException)map.put("msg","密码过期,登录失败");
                    ObjectMapper om= new ObjectMapper();
                    out.write(om.writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/admin/selectUsername","/admin/register","/company/invite/*").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .addLogoutHandler((req, resp, authentication) ->
                {

                }).logoutSuccessHandler((httpServletRequest, resp, authentication) ->
        {
            resp.setContentType("json/application;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            Map<String,Object> map=new HashMap<>();
            map.put("status",200);
            map.put("msg","注销成功");
            ObjectMapper objectMapper = new ObjectMapper();
            writer.write(objectMapper.writeValueAsString(map));
            writer.flush();
            writer.close();
        });
        http.rememberMe().userDetailsService(userService);
        http.rememberMe().tokenValiditySeconds(60).tokenRepository(getPersistentTokenRepository());
        http.csrf().disable();
    }

    @Bean
    PasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    DataSource dataSource;
    @Bean
    public PersistentTokenRepository getPersistentTokenRepository()
    {
        JdbcTokenRepositoryImpl jdbcTokenRepository=new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }
}
