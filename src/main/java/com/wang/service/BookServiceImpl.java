package com.wang.service;

import com.wang.dao.BookMapper;
import com.wang.pojo.Book;

import java.util.List;

/**
 * @author wangdaye996
 * @Date 2021/4/23
 * @Time 18:29
 */
public class BookServiceImpl implements BookService{

    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Book> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public List<Book> queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
