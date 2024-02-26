package com.spring.springbootpr.Repository;

import com.spring.springbootpr.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
