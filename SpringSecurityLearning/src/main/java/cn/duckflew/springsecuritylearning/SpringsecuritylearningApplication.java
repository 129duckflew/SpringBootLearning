package cn.duckflew.springsecuritylearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true ,prePostEnabled = true)
public class SpringsecuritylearningApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringsecuritylearningApplication.class, args);
    }

}
