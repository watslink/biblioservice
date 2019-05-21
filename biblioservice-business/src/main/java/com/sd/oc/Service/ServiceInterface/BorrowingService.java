package com.sd.oc.Service.ServiceInterface;

import com.sd.oc.model.Borrowing;
import com.sd.oc.model.User;

import java.util.List;

public interface BorrowingService {

    Borrowing getBorrowing(int id);

    List<Borrowing> getAllBorrowing();

    void addBorrowing(Borrowing borrowing);

    void deleteBorrowing(Borrowing borrowing);

    void extendBorrowing(Borrowing borrowing);

    List<Borrowing>getAllBorrowingOfUser(User user);

    List<Borrowing>getAllBorrowingOutOfTIme();
}
