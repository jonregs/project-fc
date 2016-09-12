package com.rega.fc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.util.List;

/**
 * Created by jonregalado on 9/4/16.
 */
public class FoodOfferAdapter extends RecyclerView.Adapter<FoodOfferAdapter.MyViewHolder> {

    private Context mContext;
    private List<FoodOffer> foodOfferList;

    public FoodOfferAdapter(Context mContext, List<FoodOffer> foodOfferList) {
        this.mContext = mContext;
        this.foodOfferList = foodOfferList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        FoodOffer foodOffer = foodOfferList.get(position);

        // loading album cover using Glide library
        Glide.with(mContext).load(foodOffer.getThumbnail()).into(holder.thumbnail);
        holder.thumbnail.setTag(foodOffer.getThumbnail());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);

            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int id = (int) thumbnail.getTag();

                    if(id == R.drawable.brownies_top) {
                        Toast.makeText(mContext, "Brownies", Toast.LENGTH_SHORT).show();
                    }
                    else if(id == R.drawable.cake_pops_top) {
                        Toast.makeText(mContext, "Cake Pops", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return foodOfferList.size();
    }
}