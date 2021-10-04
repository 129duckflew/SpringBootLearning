package cn.duckflew.service;

import cn.duckflew.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService
{
    public Book findOneById(int id)
    {
        return new Book(id,"djkasld","dasdasd");
    }
}
