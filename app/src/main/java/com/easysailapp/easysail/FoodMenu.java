package com.easysailapp.easysail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by veron on 2/3/2018.
 */

public class FoodMenu {
    private List<Food> menuItems = new ArrayList<Food>();
    private Food foodHolder;

    public List<Food> getMenuItems() {
        return menuItems;
    }

    public FoodMenu(){
        menuItems.add(new Food("Breakfast" , "Omelete du fromage", "Eggs with cheese", "10.50"));
        menuItems.add(new Food("Breakfast" , "Pho ga", "Vietnamese noodle soup with chicken", "10.50"));
        menuItems.add(new Food("Breakfast" , "PB & J", "Classic PeanutButter with Strawberry or Mango Jelly Sandwich", "5.50"));
        menuItems.add(new Food("Breakfast" , "Cubano Sandwich", "Toasted sandwich with Ham and Swiss", "9.50"));

        menuItems.add(new Food("Lunch" , "Beef Stew", "A hearty stew with a blend of vegetables", "11.50"));
        menuItems.add(new Food("Lunch" , "Seafood Platter", "Crabs, Lobster, Shrimp and Clams. Choice of  steamed vegetables", "10.50"));

        menuItems.add(new Food("Dinner" , "Filet Mignon", " Choice cut beef with your choice of Salad or Potatoes", "12.50"));
        menuItems.add(new Food("Dinner" , "Spaghetti and Meatballs", "Fresh herbs and topped with parmesan and a side of rolls", "12.50"));

        menuItems.add(new Food("Dessert" , "Chocolate Cake", "Fudgey and amazing", "10.50"));
        menuItems.add(new Food("Dessert" , "Flan", "Delicious.", "10.50"));

        menuItems.add(new Food("Beverage" , "Iced Coffee", "Dark roasted with condensed milk", "3.50"));
        menuItems.add(new Food("Beverage" , "Soda", "Choice of Pepsi, Sprite, Fanta", "2.50"));
        menuItems.add(new Food("Beverage" , "Wine", "Fancy Red Wine", "9.50"));

    }


}
