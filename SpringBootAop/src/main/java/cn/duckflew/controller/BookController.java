package cn.duckflew.controller;

import cn.duckflew.entity.Book;
import cn.duckflew.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@CrossOrigin
public class BookController
{
    @Autowired
    BookService bookService;

    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable int id)
    {
        return  bookService.findOneById(id);
    }
}
