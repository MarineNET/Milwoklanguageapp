package com.viktorkhon.milwoklanguageapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");

        Log.v("Number one: ", words.get(0));
        Log.v("Number two: ", words.get(1));
        Log.v("Number three: ", words.get(2));
        Log.v("Number four: ", words.get(3));
        Log.v("Number five: ", words.get(4));
    }



}
