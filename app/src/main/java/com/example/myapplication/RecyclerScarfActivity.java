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
import android.view.View;
import android.widget.Button;

import com.example.myapplication.ItemsforCategorie.scarfItems;

import com.example.myapplication.Adapters.CaptionedImagesAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecyclerScarfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_scarf);

        RecyclerView recycler = findViewById(R.id.scarf_recycler);

        String[] captions = new String[scarfItems.ITEMS.length];
        int[] ids = new int[scarfItems.ITEMS.length];
        String[] prices = new String[scarfItems.ITEMS.length];
        String[] description = new String[scarfItems.ITEMS.length];

        for(int i = 0; i<captions.length;i++){
            captions[i] = scarfItems.ITEMS[i].getName();
            ids[i] = scarfItems.ITEMS[i].getImageID();
            prices[i] = scarfItems.ITEMS[i].getPrice();
            description[i] = scarfItems.ITEMS[i].getDescription();

        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids, prices,description);
        recycler.setAdapter(adapter);

        FloatingActionButton cart=findViewById(R.id.fab);
       cart.setOnClickListener(view -> startActivity(new Intent(RecyclerScarfActivity.this, CartActivity.class)));


    }
}