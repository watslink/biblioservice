package com.sd.oc.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "borrowing")
@Getter
@Setter
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowing_id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column (name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    @Column
    private boolean extended;

    public Borrowing() {
    }

    public Borrowing(Book book, User user, Date returnDate, boolean extended) {
        this.book = book;
        this.user = user;
        this.returnDate = returnDate;
        this.extended = extended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrowing borrowing = (Borrowing) o;
        return borrowing_id == borrowing.borrowing_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(borrowing_id);
    }
}
