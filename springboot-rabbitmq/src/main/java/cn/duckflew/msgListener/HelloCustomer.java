package cn.duckflew.msgListener;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello",declare = "false",autoDelete = "true"))
public class HelloCustomer
{
    @RabbitHandler
    private void getMsg(String msg)
    {
        System.out.println(msg);
    }
}
