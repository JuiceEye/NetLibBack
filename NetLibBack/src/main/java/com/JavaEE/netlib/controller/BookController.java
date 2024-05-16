package com.JavaEE.netlib.controller;

import com.JavaEE.netlib.domain.Book;
import com.JavaEE.netlib.repository.BookRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = {"/book"}
)
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    public BookController() {
    }

    @PostMapping({"/create"})
    public String createBook(@RequestBody Book book) throws Exception {
        this.bookRepository.save(book);
        return "Book created successfully!";
    }

    @GetMapping(
            path = {"/{title}"}
    )
    public Optional<Book> getBook(@PathVariable String title) {
        return Optional.ofNullable(this.bookRepository.findBookByTitle(title));
    }
}
