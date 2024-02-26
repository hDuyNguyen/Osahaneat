package com.spring.springbootpr.Entity;


import com.spring.springbootpr.Entity.Key.KeyMenuRestaurant;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.Date;


@Entity(name = "menu_restaurant")
public class MenuRestaurant {
    @EmbeddedId
    KeyMenuRestaurant keys;
    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "cate_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "res_id", insertable = false, updatable = false)
    private Restaurant restaurant;

    public KeyMenuRestaurant getKeys() {
        return keys;
    }

    public void setKeys(KeyMenuRestaurant keys) {
        this.keys = keys;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
