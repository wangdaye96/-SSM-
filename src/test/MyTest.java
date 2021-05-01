import com.wang.dao.AdminMapper;
import com.wang.pojo.Admin;
import com.wang.pojo.AdminExample;
import com.wang.pojo.Book;
import com.wang.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author wangdaye996
 * @Date 2021/4/23
 * @Time 20:37
 */
public class MyTest {
    @Autowired
    private AdminMapper adminMapper;
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookService bookService= (BookService) context.getBean("BookServiceImpl");
//        System.out.println(bookService.queryBookById(1));
//        List<Book> books = bookService.queryAllBook();
//        for (Book book:books) {
//            System.out.println(book);
//        }
//    }

    @Test
    public void test1() {
//        AdminExample example = new AdminExample();
//        AdminExample.Criteria criteria = example.createCriteria();
//        criteria.andAdminidEqualTo(1);
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }

}
