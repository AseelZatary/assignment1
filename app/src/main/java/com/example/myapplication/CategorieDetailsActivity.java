package com.example.myapplication;
/**
 *
 * This is done by Alaa Swilem 1191326
 *
 */
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class CategorieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie_details);
        ImageView img=findViewById(R.id.productPhotoMain);
        TextView txtName=findViewById(R.id.productTitle);
        TextView txtPrice=findViewById(R.id.price);
        TextView txtDes=findViewById(R.id.productInfoDescription);

        SharedPreferences sp=getApplicationContext().getSharedPreferences("MyPref", getApplicationContext().MODE_PRIVATE);
        String name=sp.getString("name","");
        //int imageID=sp.getInt("image",' ');
        //Drawable dr = ContextCompat.getDrawable(this,imageID );
        String price=sp.getString("price","");
        String description=sp.getString("description","");

        txtName.setText(name);
        txtPrice.setText(price);
        txtDes.setText(description);
        //img.setImageDrawable(dr);
    }
}