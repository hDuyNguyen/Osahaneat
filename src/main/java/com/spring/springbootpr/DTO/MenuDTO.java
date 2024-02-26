package com.spring.springbootpr.DTO;

public class MenuDTO {
    private int id;
    private String title;
    private String image;
    private boolean isFreeShip;
    private String description;
    private double price;

    private String timeShip;

    public String getTimeShip() {
        return timeShip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFreeShip() {
        return isFreeShip;
    }

    public void setFreeShip(boolean freeShip) {
        isFreeShip = freeShip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
