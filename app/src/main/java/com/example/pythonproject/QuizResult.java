package com.example.pythonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizResult extends AppCompatActivity {


    ArrayList<String> myAnsList=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);


        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.quiz) );

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);

        TextView tvAnsweredInfo =(TextView)findViewById(R.id.tvAnsweredInfo);
        TextView t=(TextView)findViewById(R.id.textResult);


        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        int totalQs= b.getInt("totalQs");
        myAnsList=b.getStringArrayList("myAnsList");

        bar.setRating(score);

        tvAnsweredInfo.setText("You have answered "+score+" of "+totalQs+" questions  correctly!");

        float percentage=(score*100)/totalQs;

        if (percentage>=80 && percentage<=100){
            t.setText("Excellent !");
        }else if(percentage>=70 && percentage<=79){
            t.setText("Very Good");
        }else if(percentage>=60 && percentage<=69){
            t.setText("Good");
        }else if(percentage>=50 && percentage<=59){
            t.setText("Average!");
        }else if(percentage>=33 && percentage<=49){
            t.setText("Below Average!");
        }else{
            t.setText("Score is Poor! You need to practice more!");
        }


        Button btnDone=(Button)findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(QuizResult.this, QuizActivity.class);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        });

        Button btnViewAnswer=(Button)findViewById(R.id.btnViewAnswer);
        btnViewAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vIntent=new Intent(QuizResult.this,ViewAnswer.class);
                vIntent.putStringArrayListExtra("myAnsList",myAnsList);
                startActivity(vIntent);
                overridePendingTransition(R.anim.bounce,R.anim.bounce);

            }
        });

    }
}



