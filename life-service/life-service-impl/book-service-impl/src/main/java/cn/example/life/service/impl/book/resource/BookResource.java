package cn.example.life.service.impl.book.resource;

import cn.example.life.service.api.book.BookService;
import cn.example.life.service.api.book.module.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by 季先生 on 2018/3/20 14:20.
 */
@RestController
public class BookResource implements BookService {

    @Autowired
    @Qualifier("bookServiceImpl")// 这两个注解必须都写才有效，不写@Autowired的值为null
    private BookService bookService;

    @Override
    public Collection<Book> addAndShow(@RequestBody Book book) {
        return bookService.addAndShow(book);
    }
}
