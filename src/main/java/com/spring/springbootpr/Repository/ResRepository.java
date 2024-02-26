package com.spring.springbootpr.Repository;

import com.spring.springbootpr.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResRepository extends JpaRepository<Restaurant, Integer> {
}
