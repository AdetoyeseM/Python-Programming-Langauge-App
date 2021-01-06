package com.example.pythonproject;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.drm.DrmStore;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public TabLayout tabLayout;
    public ViewPager viewPager;
    public Toolbar toolbar;
    private NavigationView navigationView;
    MenuItem home;

    ViewFlipper vFlip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        int images[] = {
                R.drawable.pro5,
                R.drawable.pro1,
                R.drawable.pro2,
                R.drawable.pro3,
                R.drawable.pro4,
                R.drawable.pro5,
                R.drawable.pro6,
                R.drawable.pro7,
                R.drawable.pro8,
                R.drawable.pro9,


        };
        vFlip = findViewById(R.id.vFlip);
        for (int image : images) {
            flipperImages(image);
        }
    }



    @SuppressLint("NewApi")
    public void flipperImages (int images){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(images);

        vFlip.addView(imageView);
        vFlip.setFlipInterval(6000);
        vFlip.setAutoStart(true);

        vFlip.setInAnimation(this, android.R.anim.slide_in_left);
        vFlip.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void IDE(View view) {
        Intent intent = new Intent (this, Ide.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.slide_top);
    }

    public void tutorial(View view) {
        Intent intent1 = new Intent (this, Tutorial.class);
        startActivity(intent1);
        overridePendingTransition(R.anim.fade_in,R.anim.slide_top);
    }

    public void Programs(View view) {
        Intent intentp = new Intent(this, programs.class);
        startActivity(intentp);
        overridePendingTransition(R.anim.bounce,R.anim.fade_out);
    }

    public void Quiz(View view) {
        Intent intent3 = new Intent (this,QuizActivity.class);
        startActivity(intent3);
        overridePendingTransition(R.anim.move_left,R.anim.fade_out);
    }

    public void Submit(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("email"));
        String[] s =  {"usmanol@tasued.edu.ng"};
        intent.putExtra(Intent.EXTRA_EMAIL, s);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Attach Files");
        intent.putExtra(Intent.EXTRA_TEXT, "Your Assignment Doc(s) Here" );
        intent.setType("message/rfc822");
        Intent chooser = Intent.createChooser(intent, "Submit Assignment");
        startActivity(chooser);
    }

    public void About(View view) {
        Intent in = new Intent(this, about.class);
        startActivity(in);

        overridePendingTransition(R.anim.fade_in,R.anim.slide_top);


    }

    public void Help(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("email"));
        String[] s =  {"adetoyesematthew97@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, s);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Help & Feedback");
        intent.putExtra(Intent.EXTRA_TEXT, "Help & Feedback" );
        intent.setType("message/rfc822");
        Intent chooser = Intent.createChooser(intent, "Help & Feedback");
        startActivity(chooser);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();


            if (id == R.id.home) {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

            }
            else if (id == R.id.tutorial) {
                Intent tt = new Intent (this, Tutorial.class);
                startActivity(tt);
            }
            else if (id == R.id.programs) {
                Intent pr = new Intent (this, programs.class);
                startActivity(pr);

            }
            else if (id == R.id.ide) {
                Intent ide = new Intent (this, Ide.class);
                startActivity(ide);

            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

    public void dev(MenuItem item){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Developer");
        builder.setMessage("This App is Proudly developed By \t ADETOYESE MATTHEW A.\n adetoyesematthew97@gmail.com");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.create().show();
    }
    public void share(MenuItem item) {
        Intent Sintent = new Intent (Intent.ACTION_SEND);
        Sintent.setType("text/Plain");
        startActivity(Sintent);
    }

    public void exit(MenuItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Exit App");
        builder.setMessage("Are you Sure you want to Quit this App?");
        builder.setPositiveButton("OK!!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }

        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        builder.create().show();
    }
}
