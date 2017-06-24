package com.viktorkhon.milwoklanguageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        // When the numbers category is clicked, it will open a new window
        public void openNumbersList (View view) {
            Intent createNumbers = new Intent(this, NumbersActivity.class);
            startActivity(createNumbers);
        }
}
