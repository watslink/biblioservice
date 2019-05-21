package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.BorrowingDAO;
import com.sd.oc.Service.ServiceInterface.BookService;
import com.sd.oc.Service.ServiceInterface.BorrowingService;
import com.sd.oc.model.Book;
import com.sd.oc.model.Borrowing;
import com.sd.oc.model.User;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    BorrowingDAO borrowingDAO;

    @Autowired
    BookService bookService;

    private static Logger logger = LogManager.getLogger("BorrowingServiceImpl");


    @Override
    public Borrowing getBorrowing(int id) {
        Optional<Borrowing> optBorrowing=borrowingDAO.findById(id);
        return optBorrowing.orElse(null);
    }

    @Override
    public List<Borrowing> getAllBorrowing() {
        return (List<Borrowing>)borrowingDAO.findAll();
    }

    @Override
    public void addBorrowing(Book book, User user) {
        if(book.getNbStock()>=1){
            book.setNbStock(book.getNbStock()-1);
            bookService.updateBook(book);
            Borrowing borrowing=new Borrowing(book, user);
            borrowingDAO.save(borrowing);
        }
        else
            logger.warn("impossible d'emprunter un livre-> stock=0");
    }

    @Override
    public void deleteBorrowing(Borrowing borrowing) {
        Book book=borrowing.getBook();
        book.setNbStock(book.getNbStock()+1);
        bookService.updateBook(book);
        borrowingDAO.delete(borrowing);
    }

    @Override
    public void extendBorrowing(Borrowing borrowing) {
        borrowing.extend();
        borrowingDAO.save(borrowing);
    }

    @Override
    public List<Borrowing> getAllBorrowingOfUser(User user) {
        return borrowingDAO.findByUser(user);
    }

    @Override
    public List<Borrowing> getAllBorrowingOutOfTIme() {
        return borrowingDAO.findByReturnDateBefore(LocalDate.now());
    }
}
