package com.apurba.meaningfulmotion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MultipleElementAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<MultipleElementDataItem> dataSet;

    public MultipleElementAdapter(List<MultipleElementDataItem> dataItems){
        dataSet = dataItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View header = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.multiple_element_item, parent, false);
        return new ElementHolder(header);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MultipleElementDataItem item = dataSet.get(position);
        ElementHolder viewHolder = (ElementHolder) holder;
        viewHolder.bindView(item);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }



    class ElementHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private View root;
        private Context context;

        ElementHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            root = itemView.findViewById(R.id.root_item_layout);
            context = itemView.getContext();
        }

        void bindView(MultipleElementDataItem item){
            //img.setImageResource(item.getImgID());
            animateView();
        }

        private void animateView(){
            float offset =  context.getResources().getDimensionPixelSize(R.dimen.offset_y);
            Interpolator interpolator =
                    AnimationUtils.loadInterpolator(context, android.R.interpolator.fast_out_slow_in);

            root.setVisibility(View.VISIBLE);
            root.setTranslationY(offset);
            root.setAlpha(0.85f);
            // then animate back to natural position
            root.animate()
                    .translationY(0f)
                    .alpha(1f)
                    .setInterpolator(interpolator)
                    .setDuration(500)
                    .start();
        }
    }
}
