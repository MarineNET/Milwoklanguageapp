package com.viktorkhon.milwoklanguageapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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

        words.add(new Word("Where are you going?", "minto wuksus",
                R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?",
                R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here", "әnni'nem", R.raw.phrase_come_here));


        /** Create a {@link WordAdapter}, whose data source is a list of {@link Word}s. The
         * adapter knows how to create a list items for each item in the list
         */
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        /** Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
         * There should be a {@link ListView} with the view ID called list, which is declared in
         * word_list.xml file.
         */
        ListView listView = (ListView) findViewById(R.id.list);

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
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,
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
