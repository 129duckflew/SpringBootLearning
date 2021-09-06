package cn.duckflew.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport
{
    @Resource
    private RedisConnectionFactory factory;

    @Bean
    public KeyGenerator keyGenerator()
    {
        /**
         * 缓存KEY 的生成策略   默认自动把参数名连接
         */
        return (target, method, params) ->
        {
            StringBuilder sb=new StringBuilder();
            sb.append(target.getClass().getName()).append(".");
            sb.append(method.getName()).append(".");
            for (Object object:params)
            {
                sb.append(object.toString());
            }
            return sb.toString();
        };
    }
    /**
     * 选择Redis作为缓存工具
     */
    @Bean
    public CacheManager cacheManager()
    {
        RedisCacheConfiguration cacheConfiguration=RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
                        new GenericJackson2JsonRedisSerializer()
                ))
                .entryTtl(
                        Duration.ofHours(1)
                );
        return  RedisCacheManager.builder(factory).cacheDefaults(cacheConfiguration).build();
    }
    @Bean
    public RedisTemplate<Object,Object>redisTemplate()
    {
        RedisTemplate<Object,Object>redisTemplate =new RedisTemplate<>()    ;
        redisTemplate.setConnectionFactory(factory);
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer=
                new GenericJackson2JsonRedisSerializer();
        redisTemplate.setKeySerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        return redisTemplate;
    }

}
