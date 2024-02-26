package com.spring.springbootpr.Entity;


import com.spring.springbootpr.Entity.Key.KeyOrderItem;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity(name = "order_item")
public class OrderItem {
    @EmbeddedId
    KeyOrderItem keys;
    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    private Food food;

    public KeyOrderItem getKeys() {
        return keys;
    }

    public void setKeys(KeyOrderItem keys) {
        this.keys = keys;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
