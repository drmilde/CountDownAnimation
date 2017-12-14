package com.example.milde.countdownanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroupOverlay;
import android.view.ViewOverlay;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tvZahl);

        Button btnAnimate = (Button)findViewById(R.id.btnAnimate);
        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateNumber();
            }
        });

    }

    private void animateNumber() {
        CountdowAnimation cdAnim = new CountdowAnimation(this, tv, 9);
        cdAnim.startAnimation();
    }

}
