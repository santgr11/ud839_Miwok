package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Create array of words containing phrases
        final ArrayList<Word> words = new ArrayList<Word>();
        Collections.addAll(words,
                new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going),
                new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name),
                new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is),
                new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling),
                new Word("I’m feeling good", "kuchi achit", R.raw.phrase_im_feeling_good),
                new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming),
                new Word("Yes, I’m coming", "hәә’ әәnәm", R.raw.phrase_yes_im_coming),
                new Word("I’m coming", "әәnәm", R.raw.phrase_im_coming),
                new Word("Let’s go", "yoowutis", R.raw.phrase_lets_go),
                new Word("Come here", "әnni'nem", R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, words.get(i).getSoundResourceId());
                mMediaPlayer.start();
            }
        });
    }
}
