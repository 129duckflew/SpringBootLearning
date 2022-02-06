package cn.duckflew;

import com.rabbitmq.client.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.amqp.core.ExchangeTypes;

import java.io.IOException;

@Data
@AllArgsConstructor
public class RouteTopicThread implements Runnable
{
    private String routeKey;
    @SneakyThrows
    @Override
    public void run()
    {
        Thread cur=Thread.currentThread();
        System.out.println(cur.getName()+"run============");
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("xuniji");
        connectionFactory.setVirtualHost("/mall");
        connectionFactory.setUsername("duckflew");
        connectionFactory.setPassword("123456");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        //channel 绑定交换机
        channel.exchangeDeclare("route_topic_exchange", ExchangeTypes.TOPIC);
        //  临时队列
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName,"route_topic_exchange",routeKey);

        channel.basicConsume(queueName,true,new DefaultConsumer(channel)
        {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException
            {
                System.out.println("线程->["+routeKey+"]:收到消息->"+new String(body));
            }
        });
    }
}
