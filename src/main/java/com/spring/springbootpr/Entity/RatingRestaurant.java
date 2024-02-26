package com.spring.springbootpr.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;


@Entity(name = "rating_restaurant")
public class RatingRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id", insertable=false, updatable=false)
    private int userId;
    @Column(name = "res_id", insertable=false, updatable=false)
    private int resId;
    @Column(name = "content")
    private String content;
    @Column(name = "rate_point")
    private int ratePoint;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "res_id")
    private Restaurant restaurant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRatePoint() {
        return ratePoint;
    }

    public void setRatePoint(int ratePoint) {
        this.ratePoint = ratePoint;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
