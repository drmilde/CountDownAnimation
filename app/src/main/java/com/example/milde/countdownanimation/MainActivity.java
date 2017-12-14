package com.example.milde.countdownanimation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tvZahl);

        final Button btnAnimate = (Button)findViewById(R.id.btnAnimate);
        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateNumber();
            }
        });

    }

    private void animateNumber() {
        /**
        AnimatorSet set = (AnimatorSet) AnimatorInflater
                .loadAnimator(getApplicationContext(), R.animator.scale_down_animator);
        set.setTarget(tv);
        set.start();
         **/
        CountdowAnimation anim = new CountdowAnimation(this, tv, 9);
        anim.startAnimation();
    }

}
