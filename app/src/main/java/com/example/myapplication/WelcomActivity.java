package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Categories.categories;

public class WelcomActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    String[] cardi = { "Cardigan for ...","Cardigan for kids", "Cardigan for Adults"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

        ArrayAdapter<categories> listAdapter =new  ArrayAdapter<categories>
          (this, android.R.layout.simple_list_item_1, categories.categories);
        ListView listView = findViewById(R.id.listCategorie);
        listView.setAdapter(listAdapter);

        Spinner spin = findViewById(R.id.cardiSpinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                cardi);

        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        spin.setAdapter(ad);

        AdapterView.OnItemClickListener itemClickListener=new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                if (position == 0){
                    Intent intent = new Intent(WelcomActivity.this, RecyclerScarfActivity.class);
                    intent.putExtra("Categorie_id", (int) id);
                    startActivity(intent);
            }else if(position==1)
                {
                    Intent intent = new Intent(WelcomActivity.this, RecyclerBagActivity.class);
                    intent.putExtra("Categorie_id", (int) id);
                    startActivity(intent);
                }else if(position==2)
                {
                    Intent intent = new Intent(WelcomActivity.this, RecyclerMiniBagActivity.class);
                    startActivity(intent);
                }else
                {
                    Intent intent = new Intent(WelcomActivity.this, RecyclerQuiltActivity.class);
                    intent.putExtra("Categorie_id", (int) id);
                    startActivity(intent);
                }
            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        if(position==1)
        {
            Intent intent = new Intent(WelcomActivity.this, RecyclerCardKidsActivity.class);
            intent.putExtra("Categorie_id", (int) id);
            startActivity(intent);
        }else if(position==2)
        {
            Intent intent = new Intent(WelcomActivity.this, RecyclerCardAdultsActivity.class);
            intent.putExtra("Categorie_id", (int) id);
            startActivity(intent);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}