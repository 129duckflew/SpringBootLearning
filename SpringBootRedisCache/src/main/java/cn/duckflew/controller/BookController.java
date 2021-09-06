package cn.duckflew.controller;

import cn.duckflew.entity.Book;
import cn.duckflew.mapper.BookMapper;
import cn.duckflew.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class BookController
{
    @Autowired
    DataSource dataSource;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    BookService bookService;
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
        return bookService.findOneById(id);
    }
    @PutMapping("/books/{id}")
    public int updateById(@PathVariable int id,@RequestBody  Book book)
    {
        return bookMapper.updateByPrimaryKey(book);
    }
    @PostMapping("/books")
    public int addBook(@RequestBody Book book)
    {
        int insert = bookMapper.insert(book);
        log.info(dataSource.toString());
        return insert;
    }
}
