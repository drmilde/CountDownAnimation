package com.example.milde.countdownanimation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by milde on 13.12.17.
 */

public class CountdowAnimation implements Animation.AnimationListener {
    private TextView tv;
    private int count = 10;
    private Context ctx;

    private Animation anim;

    public CountdowAnimation(Context ctx, TextView tv, int count) {
        this.tv = tv;
        this.count = count;
        this.ctx = ctx;

        anim = AnimationUtils.loadAnimation(ctx, R.anim.scale_down);
        anim.setAnimationListener(this);

    }

    public void startAnimation() {
        tv.startAnimation(anim);
    }


    // interface routines

    @Override
    public void onAnimationStart(Animation animation) {
        tv.setText("" + count);
        count = count - 1;
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        anim.cancel();  // IMPORTANT ... animation must be canceled
                        // to avoid double calling of AnimationListener

        // restart animation
        if (count >= 0) {
            startAnimation();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}
