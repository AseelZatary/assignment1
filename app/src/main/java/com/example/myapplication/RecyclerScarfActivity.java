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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.ItemsforCategorie.scarfItems;

import com.example.myapplication.Adapters.CaptionedImagesAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.volley.Response;

import java.util.ArrayList;
import java.util.List;


public class RecyclerScarfActivity extends AppCompatActivity {
    private static  final String BASE_URL = "http://10.0.2.2:84/rest2/get_items.php";
    private List<scarfItems> items = new ArrayList<>();

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
        loadItems();
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids, prices,description);
        recycler.setAdapter(adapter);

        FloatingActionButton cart=findViewById(R.id.fab);
       cart.setOnClickListener(view -> startActivity(new Intent(RecyclerScarfActivity.this, CartActivity.class)));

    }
    private void loadItems() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        try {

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i<array.length(); i++){

                                JSONObject object = array.getJSONObject(i);

                                String name = object.getString("name");
                                String image = object.getString("image");



                                //scarfItems scarf = new scarfItems(name, image);
                               // items.add(scarf);
                            }

                        }catch (Exception e){

                        }

                        /*CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(RecyclerScarfActivity.this,
                                items);
                        recycler.setAdapter(adapter);*/

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Toast.makeText(RecyclerScarfActivity.this, error.toString(),Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(RecyclerScarfActivity.this).add(stringRequest);

    }
}