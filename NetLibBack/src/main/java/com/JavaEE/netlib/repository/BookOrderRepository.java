//package com.JavaEE.netlib.repository;
//
//import com.JavaEE.netlib.domain.BookOrder;
//import jakarta.transaction.Transactional;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface BookOrderRepository extends JpaRepository<BookOrder, Long> {
//    @Override
//    @Transactional
//    BookOrder save(BookOrder bookOrder) {
//        bookOrder.getOrder().addBookOrder(bookOrder);
//        bookOrder.getBook().addBookOrder(bookOrder);
//
//        return bookRepository.save(bookOrder);
//    }
//}
//
