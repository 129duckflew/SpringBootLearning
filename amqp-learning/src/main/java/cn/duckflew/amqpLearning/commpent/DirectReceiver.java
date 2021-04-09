package cn.duckflew.amqpLearning.commpent;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver
{
    @RabbitListener(queues = "hello-queue")
    public void handle1(String msg)
    {
        System.out.println("handle1:"+msg);
    }
}
