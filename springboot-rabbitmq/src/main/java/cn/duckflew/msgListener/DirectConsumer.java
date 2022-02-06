package cn.duckflew.msgListener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectConsumer
{
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(type = ExchangeTypes.TOPIC,name = "spring.boot.topic"),
                    key = "*.rabbit.*"
            )
    })
    public void getDirectMsg(String msg)
    {
        System.out.println("接受*.rabbit.*的消息======>"+msg);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(type = ExchangeTypes.TOPIC,name = "spring.boot.topic"),
                    key = "lazy.#"
            )
    })
    public void getDirectMsg2(String msg)
    {
        System.out.println("lazy.#的消息======>"+msg);
    }
}
