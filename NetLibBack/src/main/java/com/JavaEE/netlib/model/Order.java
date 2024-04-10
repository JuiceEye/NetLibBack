//package com.JavaEE.netlib.models;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table
//public class Order {
//    @Id
//    @SequenceGenerator(
//            name = "orderSequence",
//            sequenceName = "orderSequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "orderSequence"
//    )
//    private Long id;
//    @ManyToOne
//    private User user;
//    @OneToMany(mappedBy = "catalogue", cascade = CascadeType.ALL)
//    private List<Book> books;
//    private double totalPrice;
//
//    public Order() {
//    }
//
//    public Order(Long id, User user, List<Book> books, double totalPrice) {
//        this.id = id;
//        this.user = user;
//        this.books = books;
//        this.totalPrice = totalPrice;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
//
//    public double getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//
//}
//