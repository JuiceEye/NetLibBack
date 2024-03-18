package com.JavaEE.netlib.models;

import java.util.ArrayList;
import java.util.List;

public class BookCatalogue {
    private Long id;
    private List<Book> books;

    public BookCatalogue() {
        this.books = new ArrayList<>();
    }

    public BookCatalogue(Long id) {
        this.id = id;
        this.books = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    //добавление/удаление книг из каталога, если вдруг нужно будет
    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }
}

