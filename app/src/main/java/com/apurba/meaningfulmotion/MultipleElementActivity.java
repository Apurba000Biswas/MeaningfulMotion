package com.apurba.meaningfulmotion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MultipleElementActivity extends AppCompatActivity {

    public static final String CHAOTIC_FLAG = "is-chaotic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_element);
        Intent intent = getIntent();
        boolean isChaotic = intent.getBooleanExtra(CHAOTIC_FLAG, false);
        setRecyclerView(isChaotic);
    }

    private void setRecyclerView(boolean isChaotic){
        RecyclerView recyclerView = findViewById(R.id.rv_multiple_elements);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<MultipleElementDataItem> dataItems = new ArrayList<>();
        for (int i=0; i<20; i++){
            dataItems.add(new MultipleElementDataItem("Demo", R.drawable.dhaka));
        }

        if (!isChaotic){
            MultipleElementAdapter adapter = new MultipleElementAdapter(dataItems);
            recyclerView.setAdapter(adapter);
        }else{
            MultipleElementChaoticAdapter adapter = new MultipleElementChaoticAdapter(dataItems);
            recyclerView.setAdapter(adapter);
        }
    }
}
