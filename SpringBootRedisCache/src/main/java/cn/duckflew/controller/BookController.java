package cn.duckflew.controller;

import cn.duckflew.entity.Book;
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
    BookService bookService;
    @GetMapping("/books")
    public List<Book> getAllBook()
    {
        return bookService.list();
    }
    @DeleteMapping("books/{id}")
    public boolean deleteBookById(@PathVariable int id)
    {
        return bookService.removeById(id);
    }
    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable  int id)
    {
        return bookService.findOneById(id);
    }
    @PutMapping("/books")
    public boolean updateById(@RequestBody  Book book)
    {
        return bookService.updateById(book);
    }
    @PostMapping("/books")
    public boolean addBook(@RequestBody Book book)
    {
        boolean insert = bookService.save(book);
        log.info(dataSource.toString());
        return insert;
    }
}
