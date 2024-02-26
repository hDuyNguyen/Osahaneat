package com.spring.springbootpr.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @Column(name = "is_freeship")
    private boolean is_freeship;
    @Column(name = "address")
    private String address;
    @Column(name = "open_date")
    private Date openDate;

    @OneToMany(mappedBy = "restaurant")
    private List<Promo> promoList;
    @OneToMany(mappedBy = "restaurant")
    private List<RatingRestaurant> ratingRestaurantList;
    @OneToMany(mappedBy = "restaurant")
    private List<Orders> ordersList;
    @OneToMany(mappedBy = "restaurant")
    private List<MenuRestaurant> menuRestaurantList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIs_freeship() {
        return is_freeship;
    }

    public void setIs_freeship(boolean is_freeship) {
        this.is_freeship = is_freeship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public List<Promo> getPromoList() {
        return promoList;
    }

    public void setPromoList(List<Promo> promoList) {
        this.promoList = promoList;
    }

    public List<RatingRestaurant> getRatingRestaurantList() {
        return ratingRestaurantList;
    }

    public void setRatingRestaurantList(List<RatingRestaurant> ratingRestaurantList) {
        this.ratingRestaurantList = ratingRestaurantList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public List<MenuRestaurant> getMenuRestaurantList() {
        return menuRestaurantList;
    }

    public void setMenuRestaurantList(List<MenuRestaurant> menuRestaurantList) {
        this.menuRestaurantList = menuRestaurantList;
    }
}
