package cn.duckflew.demo.task;

import cn.duckflew.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TemplateMailService
{
    @Autowired
    private MailService mailService;

    @Scheduled(cron = "0 22 1 * * ?")
    public void sendTemplateMail()
    {
        System.out.println("触发");
        SimpleDateFormat df=new SimpleDateFormat("yyyy-dd HH:mm:ss");
        System.out.println("邮件发送时间"+df.format(new Date()));
        mailService.sendTemplateMail("129duckflew@gmail.com","这是激活邮件");
    }
}
