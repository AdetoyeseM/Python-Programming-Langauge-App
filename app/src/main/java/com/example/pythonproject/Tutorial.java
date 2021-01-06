package com.example.pythonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Tutorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void intro(View view) {
        Intent intent = new Intent(this, pintro.class);
        startActivity(intent);

    }


    public void var(View view) {
        Intent vintent = new Intent (this, vintent.class);
        startActivity(vintent);
    }

    public void flo(View view) {
        Intent flo = new Intent (this, flow.class);
        startActivity(flo);
    }

    public void str(View view) {
        Intent str = new Intent(this, string.class);
        startActivity(str);
    }

    public void list(View view) {
        Intent list = new Intent(this, list.class);
        startActivity(list);
    }

    public void tuple(View view) {
        Intent tuple  = new Intent (this, tuple.class);
        startActivity(tuple);
    }
}
