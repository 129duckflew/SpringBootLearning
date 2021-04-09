package cn.duckflew.demo.task;

import cn.duckflew.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MailTask
{
    @Autowired
    MailService mailService;
    @Scheduled(cron = "0 41 0 * * ?")
    public void sendMail()
    {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-dd HH:mm:ss");
        System.out.println("邮件发送时间"+df.format(new Date()));
        mailService.sendSimpleMail("129duckflew@gmail.com","测试邮件发送 主题","来自qq邮箱对gg邮箱的问候");
    }
}
