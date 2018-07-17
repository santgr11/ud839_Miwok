package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //Create array of words containing every number from 1 to 10
        ArrayList<String> words = new ArrayList<String>();
        Collections.addAll(words, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        //Create a child TextView inside the main layout with every number
        for(String word : words) {
            TextView wordView = new TextView(this);
            wordView.setText(word);
            rootView.addView(wordView);
        }

    }
}
