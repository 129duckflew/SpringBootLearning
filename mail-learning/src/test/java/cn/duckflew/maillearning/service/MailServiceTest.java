package cn.duckflew.maillearning.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailServiceTest
{
    @Autowired
    MailService mailService;
    @Test
    public void sendMail()
    {
        mailService.sendSimpleEmail("1297087462@qq.com","129duckflew@gmail.com","1665245632@qq.com","测试邮件主题","测试邮件内容");
    }
}