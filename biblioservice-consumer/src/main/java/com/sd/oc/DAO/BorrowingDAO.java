package com.sd.oc.DAO;

import com.sd.oc.model.Borrowing;
import com.sd.oc.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BorrowingDAO extends CrudRepository<Borrowing, Integer> {

    List<Borrowing> findByUser(User user);
}
