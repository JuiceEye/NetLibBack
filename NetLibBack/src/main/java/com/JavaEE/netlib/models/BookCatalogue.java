package com.JavaEE.netlib.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class BookCatalogue {
    @Id
    @SequenceGenerator(
            name = "bookCatalogueSequence",
            sequenceName = "bookSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bookCatalogueSequence"
    )
    private Long id;
    @OneToMany(mappedBy = "catalogue", cascade = CascadeType.ALL)
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

