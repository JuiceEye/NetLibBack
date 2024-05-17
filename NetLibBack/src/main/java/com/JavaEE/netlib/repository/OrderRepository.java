package com.JavaEE.netlib.repository;

import com.JavaEE.netlib.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderById(@Param("id") Long id);

    @Modifying
    @Query("SELECT o FROM Order o WHERE o.id = :id")
    Order saveAndFlushOrder(@Param("id") Long id);
}
