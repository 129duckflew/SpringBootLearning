package cn.duckflew.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService
{
    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;
    public void sendSimpleMail(String to,String subject,String content)
    {
        try
        {
            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(message);
            System.out.println("简单邮件已经发送");
        }
        catch (Exception e)
        {
            System.out.println("邮件发送失败");
        }

    }
    public void sendAttachmentMail(String to,String subject,String content,String filepath)
    {
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper= null;
        try
        {
            helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            FileSystemResource fileSystemResource=new FileSystemResource(filepath);
            String fileName=filepath.substring(0,filepath.lastIndexOf("."));
            helper.addAttachment(fileName,fileSystemResource);
            mailSender.send(message);
            System.out.println("带附件的邮件发送成功");
        } catch (MessagingException e)
        {
            e.printStackTrace();
            System.out.println("带附件的邮件发送失败");
        }

    }

    @Autowired
    private TemplateEngine templateEngine;
    public void sendTemplateMail(String to,String subject)
    {
         try
         {
             MimeMessage message=mailSender.createMimeMessage();
             MimeMessageHelper helper=new MimeMessageHelper(message,true);
             Context context=new Context();
             context.setVariable("id",666);
             String emailContext = templateEngine.process("email", context);

             helper.setFrom(from);
             helper.setTo(to);
             helper.setText(emailContext,true);//true表示支持html格式
             helper.setSubject(subject);

             mailSender.send(message);
             System.out.println("带模板的邮件已经发送");

         }
         catch (MessagingException e)
         {
             e.printStackTrace();
             System.out.println("带模板的邮件发送失败");
         }
    }
}
