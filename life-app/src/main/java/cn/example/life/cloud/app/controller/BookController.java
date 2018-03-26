package cn.example.life.cloud.app.controller;

import cn.example.life.service.api.book.BookService;
import cn.example.life.service.api.book.module.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by 季先生 on 2018/3/26 15:10.
 */
@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "addAndShow", method = RequestMethod.POST)                     
    public List<Book> addAndShow(Book book) {
        log.info("执行到book服务addAndShow方法");
        Collection<Book> books = bookService.addAndShow(book);
        return (List<Book>) books;
    }
}
