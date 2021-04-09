package cn.duckflew.maillearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService
{
    @Autowired
    JavaMailSender javaMailSender;

    public void sendSimpleEmail(String from,String to,String cc,String subject,String content)
    {
        SimpleMailMessage sm=new SimpleMailMessage();
        sm.setFrom(from);
        sm.setTo(to);
        sm.setCc(cc);
        sm.setSubject(subject);
        sm.setText(content);

        javaMailSender.send(sm);
    }
}
