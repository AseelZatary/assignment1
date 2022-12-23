package com.example.myapplication.ItemsforCategorie;

import com.example.myapplication.R;

public class scarfItems {

    private String name;
    private int imageID;
    private String price;
    boolean isHighlyRated= false;
    private String description;

    public static final scarfItems[] ITEMS = {
            new scarfItems("Pastel purple and white Scarf", R.drawable.scarf1,"₪49.99","A really pretty pastel purple and white scarf to wear in coldness."),
            new scarfItems("Pastel, bright Scarf", R.drawable.scarf3,"₪59.99","A really calming mixed pastel colors scarf to wear in winter."),
            new scarfItems("Warm Scarf", R.drawable.scarf4,"₪39.99","A mixed warm colors scarf to wear in autumn."),
            new scarfItems("Bright, joyful Scarf", R.drawable.scarf5,"₪69.99","A cute mix of joyful colors scarf to warm you."),
            new scarfItems("Green and white Scarf", R.drawable.scarf2,"₪49.99","A scarf to warm your neck from coldness.")
    };
    private scarfItems(String name, int imageID,String price, String description){
        this.name = name;
        this.imageID = imageID;
        this.price=price;
        this.description=description;
    }
    public String getName(){return name;}
    public int getImageID(){return imageID;}
    public String getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
}
