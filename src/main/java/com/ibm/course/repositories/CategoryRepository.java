package com.ibm.course.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}