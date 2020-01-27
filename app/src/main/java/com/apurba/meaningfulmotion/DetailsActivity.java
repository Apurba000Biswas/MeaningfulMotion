package com.apurba.meaningfulmotion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.slice.Slice;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.animation.AnimationUtils;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatils_acitvity);

        Slide slide = new Slide(Gravity.BOTTOM);
        slide.addTarget(R.id.textView2);
        slide.addTarget(R.id.textView);
        slide.setInterpolator(AnimationUtils.loadInterpolator(this
                , android.R.interpolator.linear_out_slow_in));
        slide.setDuration(500);

        getWindow().setEnterTransition(slide);
    }
}
