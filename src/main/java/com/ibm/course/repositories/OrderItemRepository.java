package com.ibm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.course.entities.OrderItem;

@Repository // indica que é o nosso repositorio
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
