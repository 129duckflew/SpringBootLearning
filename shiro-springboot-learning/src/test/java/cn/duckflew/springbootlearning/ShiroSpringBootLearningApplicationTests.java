package cn.duckflew.springbootlearning;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroSpringBootLearningApplicationTests
{

    @Test
    void contextLoads()
    {
        Md5Hash md5Hash=new Md5Hash("123456");
        md5Hash.setIterations(1024);
        System.out.println(md5Hash.toHex());
    }

}
