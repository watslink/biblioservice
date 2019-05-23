package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.BookDAO;
import com.sd.oc.Service.ServiceInterface.BookService;
import com.sd.oc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDAO bookDAO;

    @Override
    public Book getBook(int id) {
        Optional<Book> optBook=bookDAO.findById(id);
        return optBook.orElse(null);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return (List<Book>)bookDAO.findAll();
    }
}
