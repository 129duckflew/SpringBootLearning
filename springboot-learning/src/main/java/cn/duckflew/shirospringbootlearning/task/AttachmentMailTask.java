package cn.duckflew.shirospringbootlearning.task;

import cn.duckflew.shirospringbootlearning.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class AttachmentMailTask
{
    @Autowired
    MailService mailService;
    @Scheduled(cron = "0 53 0 * * ?")
    public void sendAttachmentMail()
    {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-dd HH:mm:ss");
        System.out.println("邮件发送时间"+df.format(new Date()));
        String filepath="F:\\图片\\鬼刀\\girl.png";
        mailService.sendAttachmentMail("129duckflew@gmail.com","测试邮件发送 主题","发送附件给你拉",filepath);

    }
}
