package com.apurba.meaningfulmotion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MultipleElementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_element);

        setRecyclerView();
    }

    private void setRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rv_multiple_elements);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<MultipleElementDataItem> dataItems = new ArrayList<>();
        for (int i=0; i<20; i++){
            dataItems.add(new MultipleElementDataItem("Demo", R.drawable.dhaka));
        }

        MultipleElementAdapter adapter = new MultipleElementAdapter(dataItems);
        recyclerView.setAdapter(adapter);
    }
}
