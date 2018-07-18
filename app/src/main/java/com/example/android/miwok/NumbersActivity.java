package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Create array of words containing every number from 1 to 10
        final ArrayList<Word> words = new ArrayList<Word>();
        Collections.addAll(words,
                new Word("one", "lutti", R.drawable.number_one, R.raw.number_one),
                new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two),
                new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three),
                new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four),
                new Word("five", "massokka", R.drawable.number_five, R.raw.number_five),
                new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six),
                new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven),
                new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight),
                new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine),
                new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, words.get(i).getSoundResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
