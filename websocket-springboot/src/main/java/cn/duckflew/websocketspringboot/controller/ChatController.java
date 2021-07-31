package cn.duckflew.websocketspringboot.controller;

import cn.duckflew.websocketspringboot.entity.MessageBody;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController
{
    @Autowired
    private SimpMessagingTemplate messagingTemplate;//1


    @MessageMapping("/chat")
    public void  handle(@Header("token")String token, MessageBody msg)
    {
        String username=token;  //处理之后得到token 这里暂且直接
        System.out.println(token);
        if (username .equals("kefu")) {//3
            messagingTemplate.convertAndSendToUser("user2",
                    "/queue/notifications", username  + "-send:"
                            + msg); //4
        } else {
            messagingTemplate.convertAndSendToUser("user1",
                    "/queue/notifications", username  + "-send:"
                            + msg);
        }
    }
}
