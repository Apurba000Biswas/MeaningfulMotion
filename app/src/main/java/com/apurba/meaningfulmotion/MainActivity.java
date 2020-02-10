package com.apurba.meaningfulmotion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onActivityTransitionButtonClick(View view) {
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.TOP);

        ViewGroup viewGroup = findViewById(R.id.main_container);
        TransitionManager.beginDelayedTransition(viewGroup, slide);
        ImageView image = findViewById(R.id.imageView);
        image.setVisibility(View.GONE);

        Intent gridIntent = new Intent(this, GridImageActivity.class);
        startActivity(gridIntent);
    }

    public void onSharedElementTransitionClicked(View view) {
        Intent gridIntent = new Intent(this, GridImage2.class);
        startActivity(gridIntent);
    }

    public void onInstructiveMotionClicked(View view) {
        Intent instructiveMotionIntent = new Intent(this, InstructiveMotionActivity.class);
        startActivity(instructiveMotionIntent);
    }
}
