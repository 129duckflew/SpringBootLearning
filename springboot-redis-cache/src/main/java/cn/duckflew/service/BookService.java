package cn.duckflew.service;

import cn.duckflew.entity.Book;
import cn.duckflew.mapper.BookMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class BookService  extends ServiceImpl<BookMapper,Book>
{
    @Autowired
    BookMapper bookMapper;

    @Cacheable(cacheNames = "cachetest")
    public Book findOneById(int id)
    {
        return bookMapper.selectById(id);
    }
}
