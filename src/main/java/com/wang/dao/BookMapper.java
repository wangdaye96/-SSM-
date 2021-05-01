package com.wang.dao;

import com.wang.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangdaye996
 * @Date 2021/4/23
 * @Time 17:58
 */
public interface BookMapper {
    //增加一个Book
    int addBook(Book book);

    //根据id删除一个Book
    int deleteBookById(@Param("bookId") int id);

    //更新Book
    int updateBook(Book book);

    //根据id查询,返回一个Book
    Book queryBookById(@Param("bookId") int id);

    //查询全部Book,返回list集合
    List<Book> queryAllBook();

    //根据name查询,返回一个Book
    List<Book> queryBookByName(@Param("bookName") String bookName);
}
