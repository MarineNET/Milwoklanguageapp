package com.viktorkhon.milwoklanguageapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    MediaPlayer.OnCompletionListener mOnCompletionListener =
            new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    releaseMediaPlayer();
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a new string of words in an ArrayList from a Word object
        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));


        /** Create a {@link WordAdapter}, whose data source is a list of {@link Word}s. The
         * adapter knows how to create a list items for each item in the list
         */
        final WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        /** Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
         * There should be a {@link ListView} with the view ID called list, which is declared in
         * word_list.xml file.
         */
        final ListView listView = (ListView) findViewById(R.id.list);

        /** Make the {@link ListView} use the {@link WordAdapter} we created above, so
         * that the {@link ListView} will display list items for each {@link Word} in the list.
         */
        listView.setAdapter(adapter);

        // Use setOnItemClickListener on ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            // Override onItemClick method by extracting a position from a list and assigning
            // appropriate audio file to that position
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                // Get the {@link Word} object located at the position of words ArrayList<Word>
                Word word = words.get(position);

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Instantiate MediaPlayer variable and use .create method
                //@param NumbersActivity.this refers to the current activity
                //@param word.getAudio(), gets an integer location of an audio file for each object
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,
                        word.getAudio());
                //starts playing audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that once the sound is finished playing
                // we stop and release the media player
                mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
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

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release media player resources because we don't want
        // the app to be playing sounds anymore
        releaseMediaPlayer();
    }
}