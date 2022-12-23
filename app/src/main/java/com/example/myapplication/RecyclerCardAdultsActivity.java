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
import com.example.myapplication.ItemsforCategorie.cardiganAdultsItems;
import com.example.myapplication.ItemsforCategorie.scarfItems;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecyclerCardAdultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card_adults);

        RecyclerView recycler = findViewById(R.id.card_adults_recycler);

        String[] captions = new String[cardiganAdultsItems.ITEMS.length];
        int[] ids = new int[cardiganAdultsItems.ITEMS.length];
        String[] prices= new String[cardiganAdultsItems.ITEMS.length];
        String[] description = new String[scarfItems.ITEMS.length];


        for(int i = 0; i<captions.length;i++){
            captions[i] = cardiganAdultsItems.ITEMS[i].getName();
            ids[i] = cardiganAdultsItems.ITEMS[i].getImageID();
            prices[i] = cardiganAdultsItems.ITEMS[i].getPrice();
            description[i] = cardiganAdultsItems.ITEMS[i].getDescription();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids, prices,description);
        recycler.setAdapter(adapter);
        FloatingActionButton cart=findViewById(R.id.fab);
        cart.setOnClickListener(view -> startActivity(new Intent(RecyclerCardAdultsActivity.this, CartActivity.class)));
    }
}