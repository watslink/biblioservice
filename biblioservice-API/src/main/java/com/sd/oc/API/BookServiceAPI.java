package com.sd.oc.API;


import com.sd.oc.Service.ServiceImpl.BookServiceImpl;
import com.sd.oc.Service.ServiceInterface.BookService;
import com.sd.oc.model.Book;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService (serviceName = "BookAPI")
public class BookServiceAPI  {

    ApplicationContext context= new AnnotationConfigApplicationContext(ConfigurationAPI.class);

    BookService bookService=context.getBean(BookService.class);


    @WebMethod (operationName = "findById")
    public Book findbyId(@WebParam(name="book_id") int id){
        Book book=bookService.get(id);
        return book;
    }


}
