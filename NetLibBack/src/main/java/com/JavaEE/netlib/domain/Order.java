package com.JavaEE.netlib.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
        name = "orders"
)
public class Order {
    @Id
    @SequenceGenerator(
            name = "orderSequence",
            sequenceName = "orderSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orderSequence"
    )
    private Long id;
    @ManyToOne
    private User user;
//    @OneToMany(
//            mappedBy = "order",
//            cascade = {CascadeType.ALL}
//    )
//    private List<Book> books;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private double totalPrice;

    public Order() {
    }

    public Order(Long id, User user, Book book, double totalPrice) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
