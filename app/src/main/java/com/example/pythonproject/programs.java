package com.example.pythonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class programs extends AppCompatActivity {


    String[] data = {
              " 1.  Hello-World!",
              " 2.  Python Program to Calculate Average of Numbers",
              " 3.  Python Program to Swap Numbers"
            , " 4.  Python Program to Reverse a number"
            , " 5.  Odd Numbers"
            , " 6.  Python program to Check if a Number is palindrome"
            , " 7.  Python Program to print an Identity Matrix"
            , " 8.  Python Program to Print an Inverted Star Pattern"
            , " 9.  Python Program to Compute Simple Interest"
            , " 10. Leap Year Check"
            , " 11. Height-Feet/Inches Conversion"
            , " 12. Python Program to Convert Temperature"
            , " 13. Python Program to print Prime factors of an Integer"
            , " 14. Armstrong Number check"
            , " 15. Pascal triangle"
            , " 16. LCM of numbers",
              " 17. GCD of numbers"
            , " 18. Area of Triangle"
            , " 19. Python Program to Calculate Gravitational Force"
            , " 20. Python Program to Search a given List"
            , " 21. Anagrams Strings Check"
            , " 22. Python Program to Check Vowels in a String "
            , " 23. Python Program to Calculate the length of a string "
            , " 24. Factorial of a Number"
            , " 25. Reverse a String Using Recursion"
            , " 26. Fibonacci Series using Recursion"
            , " 27. Largest Even and Largest Odd Number Check"
            , " 28. Sequential Search"
            , " 29. Bubble Sort algorithm"
            , " 30. Selection Sort"
            , " 31. Insertion sort Algorithm"
            , " 32. Merge Sort Algorithm"
            , " 33. Quick Sort Algorithm"
            , " 34. Counting sort",
              " 35. Binary Search Algorithm"




    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.pro) );

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ListView listView = (ListView) findViewById(R.id.listView2);
        programAdater programAdater = new programAdater(this, data);
        listView.setAdapter(programAdater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        Intent h1 = new Intent (programs.this, prog1.class);
                        startActivity(h1);
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                        break;
                    case 1:
                        Intent h2 = new Intent (programs.this, prog2.class);
                        startActivity(h2);
                        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                        break;
                }
            }
        });

    }
}
