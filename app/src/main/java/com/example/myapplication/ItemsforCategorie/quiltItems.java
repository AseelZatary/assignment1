package com.example.myapplication.ItemsforCategorie;
/**
 *
 * This is done by Aseel Zatary 1181130 and Alaa Swilem 1191326
 *
 */
import com.example.myapplication.R;

public class quiltItems {
     private String name;
     private int imageID;
    private String price;
    private String description;


    public static final quiltItems[] ITEMS = {
          new quiltItems("Green and white quilt", R.drawable.quilt1,"₪99.99","A really warm quilt to warm you in the winter."),
          new quiltItems("Carhartt quilt", R.drawable.quilt2,"₪109.99","a pretty multicolor quilt to put it on your shoulders."),
          new quiltItems("Box quilt", R.drawable.quilt3,"₪199.99","A warm colors quilt to warm your knees.")
    };
    private quiltItems(String name, int imageID,String price, String description){
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

 /**   private String productCode;
    private String name;
    private double price;
    private String description;
    private int photo;
    private boolean isHighlyRated= false;

    public quiltItems(String productCode, String name, double price, String description, int photo, boolean isHighlyRated) {
    }

    public static final quiltItems[] items= {
            new quiltItems(
                    "cardAdult1",
                    "Purple Adult cardigan",
                    49.99,
                    "Slik cardigan for adults.",
                    R.drawable.quilt1,
                    true
            ),
            new quiltItems(
                    "cardAdult1",
                    "Purple Adult cardigan",
                    49.99,
                    "Slik cardigan for adults.",
                    R.drawable.quilt2,
                    true
            ),
            new quiltItems(
                    "cardAdult1",
                    "Purple Adult cardigan",
                    49.99,
                    "Slik cardigan for adults.",
                    R.drawable.quilt3,
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
