package com.JavaEE.netlib.controller;

import com.JavaEE.netlib.domain.Book;
import com.JavaEE.netlib.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/create")
    public String createBook(@RequestBody Book book) throws Exception {
        bookRepository.save(book);
        return "Book created successfully!";
    }

    @GetMapping(path = "/{title}")
    public Optional<Book> getBook(@PathVariable String title) {
        return Optional.ofNullable(bookRepository.findBookByTitle(title));
    }
}
