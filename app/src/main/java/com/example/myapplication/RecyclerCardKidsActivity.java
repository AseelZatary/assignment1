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
import com.example.myapplication.ItemsforCategorie.cardiganKidsItems;
import com.example.myapplication.ItemsforCategorie.scarfItems;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecyclerCardKidsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recycler_card_kids);

            RecyclerView recycler = findViewById(R.id.card_kids_recycler);

            String[] captions = new String[cardiganKidsItems.ITEMS.length];
            int[] ids = new int[cardiganKidsItems.ITEMS.length];
            String[] prices= new String[cardiganKidsItems.ITEMS.length];
            String[] description = new String[scarfItems.ITEMS.length];


            for(int i = 0; i<captions.length;i++){
                captions[i] = cardiganKidsItems.ITEMS[i].getName();
                ids[i] = cardiganKidsItems.ITEMS[i].getImageID();
                prices[i] = cardiganKidsItems.ITEMS[i].getPrice();
                description[i] = cardiganKidsItems.ITEMS[i].getDescription();
            }
            recycler.setLayoutManager(new LinearLayoutManager(this));
            CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids, prices,description);
            recycler.setAdapter(adapter);
            FloatingActionButton cart=findViewById(R.id.fab);
            cart.setOnClickListener(view -> startActivity(new Intent(RecyclerCardKidsActivity.this, CartActivity.class)));
        }
}
