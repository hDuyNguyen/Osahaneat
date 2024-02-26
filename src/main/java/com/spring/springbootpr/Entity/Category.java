package com.spring.springbootpr.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_cate")
    private String nameCate;
    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(mappedBy = "category")
    private List<Food> foodList;
    @OneToMany(mappedBy = "category")
    private List<MenuRestaurant> menuRestaurantList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<MenuRestaurant> getMenuRestaurantList() {
        return menuRestaurantList;
    }

    public void setMenuRestaurantList(List<MenuRestaurant> menuRestaurantList) {
        this.menuRestaurantList = menuRestaurantList;
    }
}
