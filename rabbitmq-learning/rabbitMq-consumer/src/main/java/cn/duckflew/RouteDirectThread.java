package cn.duckflew;

import com.rabbitmq.client.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.ExchangeTypes;

import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDirectThread implements Runnable
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
        channel.exchangeDeclare("route_direct_exchange", ExchangeTypes.DIRECT);
        //  临时队列
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName,"route_direct_exchange", routeKey);
        channel.basicConsume(queueName,true,new DefaultConsumer(channel)
        {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException
            {
                System.out.println(cur.getName()+":"+new String(body));
            }
        });
    }
}
