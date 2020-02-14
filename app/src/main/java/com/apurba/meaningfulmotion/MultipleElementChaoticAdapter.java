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
import java.util.Random;

public class MultipleElementChaoticAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MultipleElementDataItem> dataSet;

    public MultipleElementChaoticAdapter(List<MultipleElementDataItem> dataSet){
        this.dataSet = dataSet;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View header = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.multiple_element_item, parent, false);
        return new MultipleElementChaoticAdapter.ElementHolder(header);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MultipleElementDataItem item = dataSet.get(position);
        MultipleElementChaoticAdapter.ElementHolder viewHolder = (MultipleElementChaoticAdapter.ElementHolder) holder;
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
            //img = itemView.findViewById(R.id.image);
            root = itemView.findViewById(R.id.root_item_layout);
            context = itemView.getContext();
        }

        void bindView(MultipleElementDataItem item){
            //img.setImageResource(item.getImgID());
            animateView();
        }

        private void animateView(){
            float maxWidthOffset = 2f * context.getResources().getDisplayMetrics().widthPixels;
            float maxHeightOffset = 2f * context.getResources().getDisplayMetrics().heightPixels;
            Interpolator interpolator =
                    AnimationUtils.loadInterpolator(context, android.R.interpolator.linear_out_slow_in);
            Random random = new Random();


            root.setVisibility(View.VISIBLE);
            root.setAlpha(0.85f);
            float xOffset = random.nextFloat() * maxWidthOffset;
            if (random.nextBoolean()) {
                xOffset *= -1;
            }
            root.setTranslationX(xOffset);
            float yOffset = random.nextFloat() * maxHeightOffset;
            if (random.nextBoolean()) {
                yOffset *= -1;
            }
            root.setTranslationY(yOffset);

            // now animate them back into their natural position
            root.animate()
                    .translationY(0f)
                    .translationX(0f)
                    .alpha(1f)
                    .setInterpolator(interpolator)
                    .setDuration(1000)
                    .start();
        }
    }
}
