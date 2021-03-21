package com.apurba.meaningfulmotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ExpandableItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public enum AdapterMode{
        VERTICAL, HORIZONTAL
    }

    private AdapterMode mode;

    public ExpandableItemAdapter(AdapterMode mode){
        this.mode = mode;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if (mode == AdapterMode.HORIZONTAL){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.expandable_item_horizontal, parent, false);
        }else{
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.expandable_item_vertical, parent, false);
        }
        return new ExpendableItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ExpendableItemViewHolder viewHolder = (ExpendableItemViewHolder) holder;
        viewHolder.bindView();
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    private static class ExpendableItemViewHolder extends RecyclerView.ViewHolder{

        public ExpendableItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bindView(){
            ImageView imageView = itemView.findViewById(R.id.imageView17);
            Picasso.get().load("https://lapol0.s3.amazonaws.com/media/None/100-years-of-men-fashion-cover-lapolo.jpg")
                    .into(imageView);
        }

    }

}
