package com.sd.oc.Service.ServiceInterface;

import com.sd.oc.model.Book;

import java.util.List;

public interface BookService {

    Book get(int id);

    List<Book> getAll();
}
