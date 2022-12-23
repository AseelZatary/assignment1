package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Adapters.CaptionedImagesAdapter;
import com.example.myapplication.ItemsforCategorie.BagItems;
import com.example.myapplication.ItemsforCategorie.scarfItems;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecyclerBagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_bag);

        RecyclerView recycler = findViewById(R.id.card_bags_recycler);

        String[] captions = new String[BagItems.ITEMS.length];
        int[] ids = new int[BagItems.ITEMS.length];
        String[] prices= new String[BagItems.ITEMS.length];
        String[] description = new String[scarfItems.ITEMS.length];


        for(int i = 0; i<captions.length;i++){
            captions[i] = BagItems.ITEMS[i].getName();
            ids[i] = BagItems.ITEMS[i].getImageID();
            prices[i] = BagItems.ITEMS[i].getPrice();
            description[i] = BagItems.ITEMS[i].getDescription();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids, prices,description);
        recycler.setAdapter(adapter);
        FloatingActionButton cart=findViewById(R.id.fab);
        cart.setOnClickListener(view -> startActivity(new Intent(RecyclerBagActivity.this, CartActivity.class)));
    }
}