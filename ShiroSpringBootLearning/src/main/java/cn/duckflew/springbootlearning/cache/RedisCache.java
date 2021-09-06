package cn.duckflew.springbootlearning.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Collection;
import java.util.Set;

public class RedisCache<K,V> implements Cache<K,V>
{
    @Override
    public V get(K k) throws CacheException
    {
        RedisTemplate redisTemplate= (RedisTemplate) ApplicationContextUtil.getContext().getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return (V) redisTemplate.opsForValue().get(k.toString());
    }

    @Override
    public V put(K k, V v) throws CacheException
    {
        RedisTemplate redisTemplate= (RedisTemplate) ApplicationContextUtil.getContext().getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(k.toString(),v);
        return null;
    }

    @Override
    public Object remove(Object o) throws CacheException
    {
        return null;
    }

    @Override
    public void clear() throws CacheException
    {

    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public Set keys()
    {
        return null;
    }

    @Override
    public Collection values()
    {
        return null;
    }
}
