package com.example.pythonproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import  android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class welcome extends AppCompatActivity {

        ImageView imageView;
        RingProgressBar progressBar;
        int progress = 0;

        Handler myHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        imageView = findViewById(R.id.welcm);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bouncen);
        imageView.setAnimation(animation);


        progressBar  = (RingProgressBar) findViewById(R.id.prog1);
        ringProgress();

    }
    @SuppressLint("HandlerLeak")
    public void ringProgress () {
        progressBar.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(R.anim.move_left,R.anim.fade_out);
            }
        });

        myHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0){
                    if (progress < 100){
                         progress++;
                         progressBar.setProgress(progress);
                    }
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(100);
                        myHandler.sendEmptyMessage(0);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
