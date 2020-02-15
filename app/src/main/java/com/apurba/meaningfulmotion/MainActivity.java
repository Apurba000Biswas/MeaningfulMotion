package com.apurba.meaningfulmotion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onActivityTransitionButtonClick(View view) {

        /*
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.TOP);

        ViewGroup viewGroup = findViewById(R.id.main_container);
        TransitionManager.beginDelayedTransition(viewGroup, slide);
        ImageView image = findViewById(R.id.imageView);
        image.setVisibility(View.GONE);

        Intent gridIntent = new Intent(this, GridImageActivity.class);
        startActivity(gridIntent);

         */
    }

    public void onSharedElementTransitionClicked(View view) {
        Intent gridIntent = new Intent(this, GridImage2.class);
        startActivity(gridIntent);
    }

    public void onInstructiveMotionClicked(View view) {
        Intent instructiveMotionIntent = new Intent(this, InstructiveMotionActivity.class);
        startActivity(instructiveMotionIntent);
    }

    public void onInterpolationClicked(View view) {
        Intent interpolationActivity = new Intent(this, InterpolationActivity.class);
        startActivity(interpolationActivity);
    }

    public void onMultipleElementClicked(View view) {
        Intent intent = new Intent( this, MultipleElementActivity.class);
        intent.putExtra(MultipleElementActivity.MULT_EL_FLAG, MultipleElementActivity.MULTI_EL_REGULAR);
        startActivity(intent);
    }

    public void onMultipleChaoticElementsClicked(View view) {
        Intent intent = new Intent( this, MultipleElementActivity.class);
        intent.putExtra(MultipleElementActivity.MULT_EL_FLAG, MultipleElementActivity.MULTI_EL_CHAOTIC);
        startActivity(intent);
    }

    public void onChangeSizeClicked(View view) {
        Intent intent = new Intent( this, MultipleElementActivity.class);
        intent.putExtra(MultipleElementActivity.MULT_EL_FLAG, MultipleElementActivity.MULTI_EL_SIZE);
        startActivity(intent);
    }

    public void onCurvedMotionClicked(View view) {
        Intent intent = new Intent( this, MultipleElementActivity.class);
        intent.putExtra(MultipleElementActivity.MULT_EL_FLAG, MultipleElementActivity.MULTI_EL_CURVE_DETAILS);
        startActivity(intent);
    }

    public void onAnimatedVectorClick(View view) {
        Intent intent = new Intent(this, HeartFillActivity.class);
        startActivity(intent);
    }

}
