package com.wang.controller;

import com.wang.pojo.Book;
import com.wang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wangdaye996
 * @Date 2021/4/23
 * @Time 19:22
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Book> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPager(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPager(Book book){
        System.out.println(book);
        bookService.addBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model,int id){
        Book book = bookService.queryBookById(id);
        model.addAttribute("Qbook",book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Book book) {
        System.out.println(book);
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Book> list = bookService.queryBookByName(queryBookName);
        model.addAttribute("list",list);
        return "allBook";
    }
}
