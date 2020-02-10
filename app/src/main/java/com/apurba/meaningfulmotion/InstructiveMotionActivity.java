package com.apurba.meaningfulmotion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;

public class InstructiveMotionActivity extends AppCompatActivity {

    private ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructive_motion);

        mScrollView = findViewById(R.id.scrollable);
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();



        final int startScrollPos = getResources()
                .getDimensionPixelSize(R.dimen.init_scroll_up_distance);

        Animator animator = ObjectAnimator.ofInt(mScrollView
                , "scrollY"
                , startScrollPos).setDuration(300);
        animator.start();
    }
}
