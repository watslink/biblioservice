package com.sd.oc.Service.ServiceInterface;

import com.sd.oc.model.Book;

import java.util.List;

public interface BookService {

    Book get(int id);

    void update(Book book);

    List<Book> getAll();
}
