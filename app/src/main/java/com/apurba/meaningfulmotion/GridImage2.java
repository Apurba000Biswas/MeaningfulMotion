package com.apurba.meaningfulmotion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GridImage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_image2);
    }

    public void onGridClicked(View view) {
        ImageView imageView = findViewById(R.id.imageView11);

        Bundle bundle = ActivityOptions
                .makeSceneTransitionAnimation(this, imageView, imageView.getTransitionName())
                .toBundle();

        Intent intent = new Intent(this, DetailsActivity.class);

        startActivity(intent, bundle);
    }
}
