package com.example.myapplication.ItemsforCategorie;

import com.example.myapplication.R;

public class BagItems {
    private String name;
    private int imageID;
    private String price;
    private String description;


    public static final BagItems[] ITEMS = {
            new BagItems("Purple and white Bag", R.drawable.bag1,"₪79.99","A cute and pretty purple and white bag."),
            new BagItems("Pastel Bag", R.drawable.bag2,"₪89.99","A cute pastel mixed colors bag."),
            new BagItems("Pink Bag", R.drawable.bag3,"₪99.99","A pretty Cross chest pink bag."),
            new BagItems("Blue and brown Bag", R.drawable.bag4,"₪79.99","A classy blue and brown bag.")

    };
    private BagItems(String name, int imageID,String price, String description){
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
  /**  private String productCode;
    private String name;
    private double price;
    private String description;
    private int photo;
    private boolean isHighlyRated= false;

    public BagItems(String productCode, String name, double price, String description, int photo, boolean isHighlyRated) {
    }

    public static final BagItems[] items= {
            new BagItems(
                    "bag1",
                    "Pastel colorful bag",
                    24.99,
                    "A Really pretty bag to add to your style.",
                    R.drawable.bag,
                    true
            )
    };

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getPhoto() {
        return photo;
    }

    public boolean isHighlyRated() {
        return isHighlyRated;
    }

    @Override
    public String toString() {
        return "Items{" +
                "productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", isHighlyRated=" + isHighlyRated +
                '}';
    }
}
**/