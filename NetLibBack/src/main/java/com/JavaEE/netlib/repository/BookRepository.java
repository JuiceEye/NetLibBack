package com.JavaEE.netlib.repository;


import com.JavaEE.netlib.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Book findBookByTitle(@Param("title") String title);
}