package com.sd.oc.Service.ServiceImpl;

import com.sd.oc.DAO.BorrowingDAO;
import com.sd.oc.Service.ServiceInterface.BorrowingService;
import com.sd.oc.model.Borrowing;
import com.sd.oc.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    BorrowingDAO borrowingDAO;

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
    public void addBorrowing(Borrowing borrowing) {
        borrowingDAO.save(borrowing);
    }

    @Override
    public void deleteBorrowing(Borrowing borrowing) {
        borrowingDAO.delete(borrowing);
    }

    @Override
    public void extendBorrowing(Borrowing borrowing) {

    }

    @Override
    public List<Borrowing> getAllBorrowingOfUser(User user) {
        return null;
    }

    @Override
    public List<Borrowing> getAllBorrowingOutOfTIme() {
        return null;
    }
}
