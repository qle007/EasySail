package com.easysailapp.easysail;

/**
 * Created by veron on 2/3/2018.
 */

public class Food {
    private String foodType;
    private String foodName;
    private String description;
    private double price;

    public Food(String foodType, String foodName, String description, double price) {
        this.foodType = foodType;
        this.foodName = foodName;
        this.description = description;
        this.price = price;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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
