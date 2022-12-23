package com.example.myapplication.ItemsforCategorie;
/**
 *
 * This is done by Aseel Zatary 1181130 and Alaa Swilem 1191326
 *
 */
import com.example.myapplication.R;

public class cardiganKidsItems {
    private String name;
    private int imageID;
    private String price;
    private String description;



    public static final cardiganKidsItems[] ITEMS = {
            new cardiganKidsItems("Pink Cardigan for a girl kid", R.drawable.kidcardigan1,"₪49.99","A cute pinky cardigan for girls."),
            new cardiganKidsItems("Blue Cardigan for a boy kid", R.drawable.kidcardigan2, "₪49.99","A cute blue cardigan for boys."),
            new cardiganKidsItems("Pink and blue Cardigan for girl kid", R.drawable.kidcardigan3, "₪89.99","A cute pinky and blue cardigan for girls.")
    };
    private cardiganKidsItems(String name, int imageID,String price, String description){
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
   /** private String productCode;
    private String name;
    private double price;
    private String description;
    int photo;
    private boolean isHighlyRated= false;

    public cardiganKidsItems(String productCode, String name, double price, String description, int photo, boolean isHighlyRated) {
    }

    public static final cardiganKidsItems[] items= {
            new cardiganKidsItems(
                    "cardAdult1",
                    "Purple Adult cardigan",
                    49.99,
                    "Slik cardigan for adults.",
                    R.drawable.kidcardigan1,
                    true
            ),
            new cardiganKidsItems(
                    "cardAdult1",
                    "Purple Adult cardigan",
                    49.99,
                    "Slik cardigan for adults.",
                    R.drawable.kidcardigan2,
                    true
            ),
            new cardiganKidsItems(
                    "cardAdult1",
                    "Purple Adult cardigan",
                    49.99,
                    "Slik cardigan for adults.",
                    R.drawable.kidcardigan3,
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