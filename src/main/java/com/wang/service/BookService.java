package com.wang.service;

import com.wang.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangdaye996
 * @Date 2021/4/23
 * @Time 18:27
 */
public interface BookService {
    //增加一个Book
    int addBook(Book book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Book book);

    //根据id查询,返回一个Book
    Book queryBookById(int id);

    //查询全部Book,返回list集合
    List<Book> queryAllBook();

    //根据name查询,返回一个Book
    List<Book> queryBookByName(@Param("bookName") String bookName);
}
