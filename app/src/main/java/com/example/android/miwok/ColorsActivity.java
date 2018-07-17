package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        //Create array of colors and its translations
        ArrayList<Word> words = new ArrayList<Word>();
        Collections.addAll(words,
                new Word("red", "weṭeṭṭi"),
                new Word("green", "chokokki"),
                new Word("brown", "ṭakaakki"),
                new Word("gray", "ṭopoppi"),
                new Word("black", "kululli"),
                new Word("white", "kelelli"),
                new Word("dusty yellow", "ṭopiisә"),
                new Word("mustard yellow", "chiwiiṭә"));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.listColors);

        listView.setAdapter(adapter);
    }
}
