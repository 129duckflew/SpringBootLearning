package boss.portal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @FileName: RedisConfig
 * @Author: zhaoxinguo
 * @Date: 2019/3/20 17:07
 * @Description: Redis配置类
 */
@Configuration
@ComponentScan("boss.portal.config")
public class RedisConfig {

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(10);
        return jedisPoolConfig;
    }

    @Value("${spring.redis.password}")
    String redisPassword;
    @Value("${spring.redis.host}")
    String redisHostName;
    @Value("${spring.redis.port}")
    int redisPort;
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName(redisHostName);
        jedisConFactory.setPort(redisPort);
        // 这里我本地的Reids没有设置密码，暂时注释掉，如果有密码，请放开下面的注释
        jedisConFactory.setPassword(redisPassword);
        jedisConFactory.setPoolConfig(jedisPoolConfig());
        jedisConFactory.setDatabase(7);
        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }

}
