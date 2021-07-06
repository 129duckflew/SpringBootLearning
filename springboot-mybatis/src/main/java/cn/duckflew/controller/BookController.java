package cn.duckflew.controller;

import cn.duckflew.entity.Book;
import cn.duckflew.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookController
{
    @Autowired
    BookMapper bookMapper;
    @GetMapping("/books")
    public List<Book> getAllBook()
    {
        return bookMapper.getAllBook();
    }
    @DeleteMapping("books/{id}")
    public int deleteBookById(@PathVariable int id)
    {
        return bookMapper.deleteByPrimaryKey(id);
    }
    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable  int id)
    {
        log.info(String.valueOf(id));
        return bookMapper.selectByPrimaryKey(id);
    }
    @PutMapping("/books/")
    public int updateById(Book book)
    {
        return bookMapper.updateByPrimaryKey(book);
    }
    @PostMapping("/books")
    public int addBook(Book book)
    {
        return bookMapper.insert(book);
    }
}
