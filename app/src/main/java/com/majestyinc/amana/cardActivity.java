package com.majestyinc.amana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class cardActivity extends AppCompatActivity {

    TextView amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_activity);

        amount = findViewById(R.id.amount);

        Intent intent = getIntent();

        String amnt = intent.getStringExtra("amount");

        amount.setText(amnt);


    }
}
