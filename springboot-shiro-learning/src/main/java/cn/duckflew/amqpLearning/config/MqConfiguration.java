package cn.duckflew.amqpLearning.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfiguration
{
    public final static String DIRECTNAME="duckflew-direct";

    @Bean
    Queue queue(){return new Queue("hello-queue");}
    @Bean
    DirectExchange directExchange()
    {
        return new DirectExchange(DIRECTNAME,true,false);

    }
    @Bean
    Binding binding()
    {
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}
