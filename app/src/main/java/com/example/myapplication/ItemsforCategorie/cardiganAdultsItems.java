package com.example.myapplication.ItemsforCategorie;

import com.example.myapplication.R;

public class cardiganAdultsItems {
    private String name;
    private int imageID;
    private String price;
    private String description;



    public static final cardiganAdultsItems[] ITEMS = {
            new cardiganAdultsItems("Purple Cardigan for adults", R.drawable.adultcardigan1,"₪99.99","A pretty purple cardigan for women."),
            new cardiganAdultsItems("Turquoise Cardigan for adults", R.drawable.adultcardigan2,"₪99.99","A rally pretty and warm colors cardigan for cafe dates."),
            new cardiganAdultsItems("Blue Cardigan for adults", R.drawable.adultcardigan3,"₪109.99","A really pretty blue cardigan to warm you in winter."),
            new cardiganAdultsItems("Bright blue Cardigan for adults", R.drawable.adultcardigan4,"₪99.99","A cute bright blue cardigan to wear it.")
    };
    private cardiganAdultsItems(String name, int imageID,String price, String description){
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