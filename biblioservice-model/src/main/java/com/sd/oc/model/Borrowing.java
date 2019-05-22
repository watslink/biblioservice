package com.sd.oc.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "borrowing")
@Getter
@Setter
@PropertySource("classpath:database.properties")
public class Borrowing {


    @Value("weekOfBorrowing")
    private Long weekOfBorrowing;

    @Value("extendWeek")
    private Long extendWeek;

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
    private LocalDate returnDate;

    @Column
    private boolean extended;

    public Borrowing() {
    }

    public Borrowing(Book book, User user) {
        this.book = book;
        this.user = user;
        this.returnDate = LocalDate.now().plus(weekOfBorrowing, ChronoUnit.WEEKS);
        this.extended = false;
    }

    public void extend(){
        this.returnDate=returnDate.plus(extendWeek, ChronoUnit.WEEKS);
        this.extended=true;
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
