package cn.duckflew.controller;

import cn.duckflew.entity.Book;
import cn.duckflew.mapper.BookMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.sql.DataSource;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin

/**
 * tags  给当前类型定义别名 可以有多个 有多个就显示多个
 */
@Api(tags = {"书籍控制器"},description = "过时了 描述 但是也可以用")
public class BookController
{
    @Autowired
    DataSource dataSource;
    @Autowired
    BookMapper bookMapper;

    @ApiOperation(value = "获取所有书籍",notes = "添加的一些描述")
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
        return bookMapper.selectByPrimaryKey(id);
    }
    @PutMapping("/books/{id}")
    public int updateById(@PathVariable int id,@ApiParam("传入要修改的Book类") @RequestBody  Book book)
    {
        return bookMapper.updateByPrimaryKey(book);
    }
    @ApiIgnore //表示不生成Api文档
    @PostMapping("/books")
    public int addBook(@ApiParam("要新增的book")@RequestBody Book book)
    {
        int insert = bookMapper.insert(book);
        log.info(dataSource.toString());
        return insert;
    }
}
