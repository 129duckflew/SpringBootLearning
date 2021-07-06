package cn.duckflew.springsecuritylearning.genPassword;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class GenPassword
{
    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    public void gen()
    {
        String rowPwd="123456";
        String encode = passwordEncoder.encode(rowPwd);
        System.out.println(encode);
    }
}
