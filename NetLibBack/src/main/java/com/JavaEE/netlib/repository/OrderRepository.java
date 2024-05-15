package com.JavaEE.netlib.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.JavaEE.netlib.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Order findOrderById(@Param("id") Long id);
}