package com.spring.springbootpr.Repository;

import com.spring.springbootpr.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CateRepository extends JpaRepository<Category, Integer> {
}
