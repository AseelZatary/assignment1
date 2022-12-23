package com.example.myapplication;
/**
 *
 * This is done by Aseel Zatary 1181130
 *
 */
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Adapters.CaptionedImagesAdapter;
import com.example.myapplication.ItemsforCategorie.BagItems;
import com.example.myapplication.ItemsforCategorie.miniBagItems;
import com.example.myapplication.ItemsforCategorie.scarfItems;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecyclerMiniBagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_mini_bag);

        RecyclerView recycler = findViewById(R.id.card_mini_bags_recycler);

        String[] captions = new String[miniBagItems.ITEMS.length];
        int[] ids = new int[miniBagItems.ITEMS.length];
        String[] prices= new String[miniBagItems.ITEMS.length];
        String[] description = new String[scarfItems.ITEMS.length];


        for(int i = 0; i<captions.length;i++){
            captions[i] = miniBagItems.ITEMS[i].getName();
            ids[i] = miniBagItems.ITEMS[i].getImageID();
            prices[i] = miniBagItems.ITEMS[i].getPrice();
            description[i] = miniBagItems.ITEMS[i].getDescription();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids, prices,description);
        recycler.setAdapter(adapter);

        FloatingActionButton cart=findViewById(R.id.fab);
        cart.setOnClickListener(view -> startActivity(new Intent(RecyclerMiniBagActivity.this, CartActivity.class)));
    }
}