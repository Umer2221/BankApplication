package com.example.movieapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLAS_TIMER=5000;

    ImageView back;
    TextView textView;

    Animation side,bott;
    SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        back=findViewById(R.id.bckim);
        textView=findViewById(R.id.pwd);

        side= AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bott= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        back.setAnimation(side);
        textView.setAnimation(bott);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                      Intent intent=new Intent(getApplicationContext(), UserDashboard.class);
                    //UserDashboard
                    startActivity(intent);
                finish();

            }
        },SPLAS_TIMER);

    }
}