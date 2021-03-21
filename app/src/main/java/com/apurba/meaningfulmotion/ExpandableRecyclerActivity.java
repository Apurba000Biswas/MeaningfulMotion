package com.apurba.meaningfulmotion;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExpandableRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_recycler_activiity);

        setRecyclerView();
    }


    private void setRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rv_expandable);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        ExpendableAdapter adapter = new ExpendableAdapter();
        recyclerView.setAdapter(adapter);
    }

}