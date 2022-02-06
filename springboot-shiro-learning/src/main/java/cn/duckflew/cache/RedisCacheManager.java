package cn.duckflew.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

public class RedisCacheManager implements CacheManager
{
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException
    {
        /**
         * 认证或者是授权缓存的统一名称
         */
        return new RedisCache<>();
    }
}
