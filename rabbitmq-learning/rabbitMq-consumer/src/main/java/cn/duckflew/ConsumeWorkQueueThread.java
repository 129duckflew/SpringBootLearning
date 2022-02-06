package cn.duckflew;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;

import java.io.IOException;

public class ConsumeWorkQueueThread implements Runnable
{
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
        channel.queueDeclare("work",true,false,false,null);
        channel.basicQos(1);  //每次只能消费一个消息
        //参数1 队列名 参数2  是否开启消息自动确认 参数3 消费消息的回调函数
        channel.basicConsume("work", false, new DefaultConsumer(channel)
        {
            @SneakyThrows
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException
            {
                System.out.println("消费者-"+cur.getName()+":"+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
                if (cur.getName().contains("1"))
                {
                        System.out.println("暂停一秒");
                        Thread.sleep(1000);
                        System.out.println("当前线程名:"+Thread.currentThread().getName());
                }
            }
        });
    }
}
