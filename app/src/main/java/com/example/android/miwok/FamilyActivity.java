package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Create array of words containing family members
        ArrayList<Word> words = new ArrayList<Word>();
        Collections.addAll(words,
                new Word("father", "әpә"),
                new Word("mother", "әṭa"),
                new Word("son", "angsi"),
                new Word("daughter", "tune"),
                new Word("older brother", "taachi"),
                new Word("younger brother", "chalitti"),
                new Word("older sister", "teṭe"),
                new Word("younger sister", "kolliti"),
                new Word("grandmother", "ama"),
                new Word("grandfather", "paapa"));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
