package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Adapters.CaptionedImagesAdapter;
import com.example.myapplication.ItemsforCategorie.BagItems;
import com.example.myapplication.ItemsforCategorie.quiltItems;
import com.example.myapplication.ItemsforCategorie.scarfItems;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecyclerQuiltActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_quilt);

        RecyclerView recycler = findViewById(R.id.card_quilts_recycler);

        String[] captions = new String[quiltItems.ITEMS.length];
        int[] ids = new int[quiltItems.ITEMS.length];
        String[] prices= new String[quiltItems.ITEMS.length];
        String[] description = new String[scarfItems.ITEMS.length];


        for(int i = 0; i<captions.length;i++){
            captions[i] = quiltItems.ITEMS[i].getName();
            ids[i] = quiltItems.ITEMS[i].getImageID();
            prices[i] = quiltItems.ITEMS[i].getPrice();
            description[i] = quiltItems.ITEMS[i].getDescription();

        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids, prices,description);
        recycler.setAdapter(adapter);

        FloatingActionButton cart=findViewById(R.id.fab);
        cart.setOnClickListener(view -> startActivity(new Intent(RecyclerQuiltActivity.this, CartActivity.class)));
    }
}