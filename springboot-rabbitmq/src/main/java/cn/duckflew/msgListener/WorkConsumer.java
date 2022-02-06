package cn.duckflew.msgListener;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkConsumer
{
    @RabbitListener(queuesToDeclare = @Queue(name = "work"))
    public void getMsg(String msg)
    {
        System.out.println("工作模型消费者1:"+msg);
    }
    @RabbitListener(queuesToDeclare = @Queue(name = "work"))
    public void getMsg2(String msg)
    {
        System.out.println("工作模型消费者2:"+msg);
    }
}
