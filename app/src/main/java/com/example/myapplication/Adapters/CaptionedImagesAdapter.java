package com.example.myapplication.Adapters;
/**
 *
 * This is done by Aseel Zatary 1181130
 *
 */
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.CategorieDetailsActivity;
import com.example.myapplication.ItemsforCategorie.scarfItems;
import com.example.myapplication.R;

import java.util.List;

public class CaptionedImagesAdapter
        extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{

    private String[] captions;
    private int[] imageIds;
    private String[] prices;
    private String[] descriptions;
    private Button btnCart;
    private SharedPreferences sp;

    private Context context;
    private List<scarfItems> items;

    public CaptionedImagesAdapter(String[] captions, int[] imageIds, String[] prices,String[] description){
        this.captions = captions;
        this.imageIds = imageIds;
        this.prices=prices;
        this.descriptions=description;

    }
    public CaptionedImagesAdapter(Context context, List<scarfItems> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,
                parent,
                false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(dr);
        TextView txt = (TextView)cardView.findViewById(R.id.txtName);
        txt.setText(captions[position]);
        TextView txt2 = (TextView)cardView.findViewById(R.id.txtprice);
        txt2.setText(prices[position]);
        btnCart=cardView.findViewById(R.id.fab);
        sp= cardView.getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences.Editor editor=sp.edit();
                String name=txt.getText().toString();
                String price=txt2.getText().toString();
                String description=descriptions[holder.getAdapterPosition() ];
                //int img=imageView.getImageAlpha();
                editor.putString("name",name);
                editor.putString("price",price);
                editor.putString("description",description);
                //editor.putInt("image",img);
                editor.commit();
                Intent intent= new Intent(cardView.getContext(), CategorieDetailsActivity.class);
                cardView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}
