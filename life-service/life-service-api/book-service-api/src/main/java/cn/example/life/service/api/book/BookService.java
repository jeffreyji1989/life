package cn.example.life.service.api.book;

import cn.example.life.service.api.book.module.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by 季先生 on 2018/3/26 13:49.
 */
@FeignClient(value = "${book.service.name}")
public interface BookService {
    @RequestMapping(value = "/book/add/find/all", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    Collection<Book> addAndShow(@RequestBody Book book);
}
