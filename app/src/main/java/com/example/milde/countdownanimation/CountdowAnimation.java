package com.example.milde.countdownanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by milde on 13.12.17.
 */

public class CountdowAnimation extends AnimatorListenerAdapter {
    private TextView tv;
    private int count = 10;
    private Context ctx;

    private AnimatorSet set ;

    public CountdowAnimation(Context ctx, TextView tv, int count) {
        this.tv = tv;
        this.count = count;
        this.ctx = ctx;

        set = (AnimatorSet) AnimatorInflater
                .loadAnimator(ctx, R.animator.scale_down_animator);
        set.addListener(this);
        set.setTarget(tv);
    }

    public void startAnimation() {
        set.start();
    }

    // Adapter methods
    @Override
    public void onAnimationCancel(Animator animation) {
        super.onAnimationCancel(animation);
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
        set.cancel();  // IMPORTANT ... animation must be canceled
        // to avoid double calling of AnimationListener

        // restart animation
        if (count >= 0) {
            startAnimation();
        }
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
        super.onAnimationRepeat(animation);
    }

    @Override
    public void onAnimationStart(Animator animation) {
        super.onAnimationStart(animation);
        tv.setText("" + count);
        count = count - 1;
    }

    @Override
    public void onAnimationPause(Animator animation) {
        super.onAnimationPause(animation);
    }

    @Override
    public void onAnimationResume(Animator animation) {
        super.onAnimationResume(animation);
    }


    // interface routines

    /**
    @Override
    public void onAnimationStart(Animation animation) {
        tv.setText("" + count);
        count = count - 1;
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        set.cancel();  // IMPORTANT ... animation must be canceled
                        // to avoid double calling of AnimationListener

        // restart animation
        if (count >= 0) {
            startAnimation();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
    **/
}
