package com.viktorkhon.milwoklanguageapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create a new string of words in an ArrayList
        ArrayList<String> words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");

        // Find the ID of Linear Layout in activity_numbers
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        // Create a variable to keep track of the current index position in the array
        int i = 0;
        // Create a new while loop to display the String Array of numbers
        while (i < words.size()) {
            // Create a new {@link TextView} that displayed the words
            TextView numbers = new TextView(this);
            // display 1 word at a time, based on the index position
            numbers.setText(words.get(i));
            // add the View as a child to the parent rootView
            rootView.addView(numbers);
            // increase index position by 1
            i++;
        }

    }
}
