package com.sd.oc.API;


import com.sd.oc.Service.ServiceInterface.BookService;
import com.sd.oc.model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "BookAPI")
public class BookServiceAPI {

    ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationAPI.class);

    BookService bookService = context.getBean(BookService.class);


    @WebMethod(operationName = "findBookById")
    public Book findBookById(@WebParam(name = "book_id") int id) {
        Book book = bookService.getBook(id);
        return book;
    }

    @WebMethod(operationName = "findAllBooks")
    public List<Book> findAll() {
        return bookService.getAllBook();
    }


}
