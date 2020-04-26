package com.example.bmicalculator;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AdviceActivity extends AppCompatActivity {
    Double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);
        setTitle("Advice based on the BMI");

        Intent adviceIntent = getIntent();
        bmi = adviceIntent.getDoubleExtra("bmi", 10.0);

        /* Big Oof.  Why Java Why
        switch (bmi) {

        }
        */

        if (bmi < 18.5) {
            TextView adviceTextTV = (TextView) findViewById(R.id.adviceText);
            adviceTextTV.setBackgroundColor(Color.BLUE);
            adviceTextTV.setTextColor(Color.WHITE);
            adviceTextTV.setText("Underweight:\n" +
                                    "You are below a healthy weight. You need to consume more calories.");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            TextView adviceTextTV = (TextView) findViewById(R.id.adviceText);
            adviceTextTV.setBackgroundColor(Color.BLUE);
            adviceTextTV.setTextColor(Color.WHITE);
            adviceTextTV.setText("Normal:\n" +
                                    "Congratulations! You are at a healthy weight.");
        } else if (bmi > 24.9 && bmi <= 29.9) {
            TextView adviceTextTV = (TextView) findViewById(R.id.adviceText);
            adviceTextTV.setBackgroundColor(Color.BLUE);
            adviceTextTV.setTextColor(Color.WHITE);
            adviceTextTV.setText("Overweight:\n" +
                                    "You are above a healthy weight. You need to watch your diet and exercise, or you will become obese.");
        } else {
            TextView adviceTextTV = (TextView) findViewById(R.id.adviceText);
            adviceTextTV.setBackgroundColor(Color.BLUE);
            adviceTextTV.setTextColor(Color.WHITE);
            adviceTextTV.setText("Obese\n" +
                                    "You are extremely overweight. You need to take drastic measures now, or medical intervention will be required.");
        }

    }
}
