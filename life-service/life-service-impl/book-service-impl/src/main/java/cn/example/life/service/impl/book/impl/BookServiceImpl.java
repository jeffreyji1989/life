package cn.example.life.service.impl.book.impl;

import cn.example.life.core.utils.IdUtil;
import cn.example.life.service.api.book.BookService;
import cn.example.life.service.api.book.module.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by 季先生 on 2018/3/26 13:54.
 */
@Service
public class BookServiceImpl implements BookService {
    private static ConcurrentMap<Long, Book> repositoryMap = new ConcurrentHashMap<>();

    @Autowired
    private IdUtil idUtil;

    @Override
    public Collection<Book> addAndShow(Book book) {
        book.setId(idUtil.nextId());
        repositoryMap.put(book.getId(), book);
        return repositoryMap.values();
    }
}
