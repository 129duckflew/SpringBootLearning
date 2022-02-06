package cn.duckflew.msgListener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutConsumer
{

    @RabbitListener(
            bindings = {
                    @QueueBinding
                    (
                            value = @Queue,
                            exchange = @Exchange(type = ExchangeTypes.FANOUT,name = "spring-boot-fanout-exchange")
                    )
            }
    )
    public void getFanoutMsg(String msg)
    {
        System.out.println("消费者1---------------->"+msg);
    }
    @RabbitListener(
            bindings = {
                    @QueueBinding
                            (
                                    value = @Queue,
                                    exchange = @Exchange(type = ExchangeTypes.FANOUT,name = "spring-boot-fanout-exchange")
                            )
            }
    )
    public void getFanoutMsg2(String msg)
    {
        System.out.println("消费者2---------------->"+msg);
    }
}
