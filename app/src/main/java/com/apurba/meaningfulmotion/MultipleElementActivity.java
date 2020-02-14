package com.apurba.meaningfulmotion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MultipleElementActivity extends AppCompatActivity {

    public static final String MULT_EL_FLAG = "is-chaotic";
    public static final int MULTI_EL_REGULAR = 1;
    public static final int MULTI_EL_CHAOTIC = 2;
    public static final int MULTI_EL_SIZE = 3;
    public static final int MULTI_EL_CURVE_DETAILS = 4;


    public static final float LARGE_SCALE = 1.5f;
    private boolean symmetric = true;
    private boolean small = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_element);
        Intent intent = getIntent();
        int isChaotic = intent.getIntExtra(MULT_EL_FLAG, MULTI_EL_REGULAR);
        setRecyclerView(isChaotic);
    }

    private void setRecyclerView(int flag){
        RecyclerView recyclerView = findViewById(R.id.rv_multiple_elements);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<MultipleElementDataItem> dataItems = new ArrayList<>();
        for (int i=0; i<20; i++){
            dataItems.add(new MultipleElementDataItem("Demo", R.drawable.dhaka));
        }

        if (flag == MULTI_EL_REGULAR){
            MultipleElementAdapter adapter = new MultipleElementAdapter(dataItems, null);
            recyclerView.setAdapter(adapter);
        }else if (flag == MULTI_EL_CHAOTIC){
            MultipleElementChaoticAdapter adapter = new MultipleElementChaoticAdapter(dataItems);
            recyclerView.setAdapter(adapter);
        }else if(flag == MULTI_EL_SIZE){
            MultipleElementAdapter adapter
                    = new MultipleElementAdapter(dataItems, new MultipleElementAdapter.itemClickListener() {
                @Override
                public void onItemClicked(View root) {
                    changeSize(root);
                }
            });
            recyclerView.setAdapter(adapter);
        }else{
            MultipleElementAdapter adapter
                    = new MultipleElementAdapter(dataItems, new MultipleElementAdapter.itemClickListener() {
                @Override
                public void onItemClicked(View root) {
                    runDetails();
                }
            });
            recyclerView.setAdapter(adapter);
        }
    }


    private void changeSize(View root){
        Interpolator interpolator = AnimationUtils.loadInterpolator(this, android.R
                .interpolator.fast_out_slow_in);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(root, View.SCALE_X, (small ? LARGE_SCALE : 1f));
        scaleX.setInterpolator(interpolator);
        scaleX.setDuration(symmetric ? 600L : 200L);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(root, View.SCALE_Y, (small ? LARGE_SCALE : 1f));
        scaleY.setInterpolator(interpolator);
        scaleY.setDuration(600L);
        scaleX.start();
        scaleY.start();

        // toggle the state so that we switch between large/small and symmetric/asymmetric
        small = !small;
        if (small) {
            symmetric = !symmetric;
        }

        RecyclerView recyclerView = findViewById(R.id.rv_multiple_elements);
        recyclerView.computeVerticalScrollExtent();
    }

    private void runDetails(){
        Intent intent = new Intent(this, ApurbaDetailsActivity.class);
        startActivity(intent);
    }
}
