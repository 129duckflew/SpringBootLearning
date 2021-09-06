package cn.duckflew.service;

import cn.duckflew.entity.Book;
import cn.duckflew.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BookService
{
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    BookMapper bookMapper;
    public Book findOneById(int id)
    {
        String key = "book_" + id; //设置key
            ValueOperations<String, Book> operations = redisTemplate.opsForValue();
            //判断redis中是否有键为key的缓存
            boolean hasKey = redisTemplate.hasKey(key);
        Book book;//从数据库中获取数据
        if (hasKey) {
            book = operations.get(key);
            System.out.println("从缓存中获得数据：" + book.getName());
        }
        else {
            book = bookMapper.selectByPrimaryKey(id);
            System.out.println("查询数据库获得数据：" + book.getName() );
            operations.set(key, book, 1, TimeUnit.HOURS); // 并写入缓存,1小时有效期
            System.out.println("添加key到缓存"+ key);
        }
        return  book ;
    }
}
