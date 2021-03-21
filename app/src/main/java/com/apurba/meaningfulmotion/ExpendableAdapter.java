package com.apurba.meaningfulmotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExpendableAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expendable_recycler_view, parent, false);
        return new ExpandableRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ExpandableRecyclerViewHolder viewHolder = (ExpandableRecyclerViewHolder) holder;
        viewHolder.bindView();
    }

    @Override
    public int getItemCount() {
        return 30;
    }


    private static class ExpandableRecyclerViewHolder extends RecyclerView.ViewHolder{

        private RecyclerView.LayoutManager verticalLayoutManager;
        private RecyclerView.LayoutManager horizontalLayoutManager;


        public ExpandableRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            horizontalLayoutManager
                    = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
            verticalLayoutManager = new LinearLayoutManager(itemView.getContext());

        }

        public void bindView(){
            RecyclerView recyclerView = itemView.findViewById(R.id.rv_expandable_inner);
            recyclerView.setHasFixedSize(true);

            recyclerView.setLayoutManager(horizontalLayoutManager);

            ExpandableItemAdapter adapter = new ExpandableItemAdapter();
            recyclerView.setAdapter(adapter);


            TextView expandMeTv = itemView.findViewById(R.id.textView6);
            expandMeTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerView.setLayoutManager(verticalLayoutManager);
                }
            });


        }


    }

}
