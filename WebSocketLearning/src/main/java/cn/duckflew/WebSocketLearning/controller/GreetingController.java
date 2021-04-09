package cn.duckflew.WebSocketLearning.controller;

import lombok.Data;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController
{
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message)
    {
        return message;
    }

    @Data
    class Message
    {
        private String name;
        private String content;
    }
}
