package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //Create array of words containing every number from 1 to 10
        ArrayList<Word> words = new ArrayList<Word>();
        Collections.addAll(words,
                new Word("one", "lutti"),
                new Word("two", "otiiko"),
                new Word("three", "tolookosu"),
                new Word("four", "oyyisa"),
                new Word("five", "massokka"),
                new Word("six", "temmokka"),
                new Word("seven", "kenekaku"),
                new Word("eight", "kawinta"),
                new Word("nine", "wo'e"),
                new Word("ten", "na'aacha"));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.listNumbers);

        listView.setAdapter(adapter);

    }
}
