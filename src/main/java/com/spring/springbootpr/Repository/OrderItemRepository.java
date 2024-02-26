package com.spring.springbootpr.Repository;

import com.spring.springbootpr.Entity.Key.KeyOrderItem;
import com.spring.springbootpr.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, KeyOrderItem> {
}
