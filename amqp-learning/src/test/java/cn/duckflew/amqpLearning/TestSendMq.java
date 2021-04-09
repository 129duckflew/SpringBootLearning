package cn.duckflew.amqpLearning;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class TestSendMq
{
    @Autowired
    RabbitTemplate rabbitTemplate;
   @Test
   public void send()
   {
        rabbitTemplate.convertAndSend("hello-queue","hello duckflew");
   }
}
