package com.example.myapplication.ItemsforCategorie;


import com.example.myapplication.R;

public class miniBagItems {
    private String name;
    private int imageID;
    private String price;
    private String description;



    public static final miniBagItems[] ITEMS = {
            new miniBagItems("Pastel mini bag", R.drawable.minibag3, "₪9.99", "A cute mini bag with pastel colors."),
            new miniBagItems("Purple and white mini bags", R.drawable.minibag1,"₪9.99","Three cute purple and white mini bags."),
            new miniBagItems("Purple and white mini bag", R.drawable.minibag2,"₪9.99","A cute purple and white mini bag."),
            new miniBagItems("Mixed Mini Bags", R.drawable.minibag,"₪9.99","A cute three mini bags with a mixed colors.")

    };

    private miniBagItems(String name, int imageID,String price, String description){
        this.name = name;
        this.imageID = imageID;
        this.price=price;
        this.description=description;
    }

    public String getName() {
        return name;
    }

    public int getImageID() {
        return imageID;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

/**    private String productCode;
    private String name;
    private double price;
    private String description;
    private int photo;
    private boolean isHighlyRated= false;

    public miniBagItems(String productCode, String name, double price, String description, int photo, boolean isHighlyRated) {
    }
    public static final miniBagItems[] items= {
            new miniBagItems(
                    "cardAdult1",
                    "Purple Adult cardigan",
                    49.99,
                    "Slik cardigan for adults.",
                    R.drawable.minibag,
                    true
            ),
            new miniBagItems(
                    "cardAdult1",
                    "Purple Adult cardigan",
                    49.99,
                    "Slik cardigan for adults.",
                    R.drawable.minibag1,
                    true
            ),
            new miniBagItems(
                    "cardAdult1",
                    "Purple Adult cardigan",
                    49.99,
                    "Slik cardigan for adults.",
                    R.drawable.minibag2,
                    true
            ),
            new miniBagItems(
                    "cardAdult1",
                    "Purple Adult cardigan",
                    49.99,
                    "Slik cardigan for adults.",
                    R.drawable.minibag3,
                    true
            ),
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
}**/
