package com.example.bmicalculator;

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
            adviceTextTV.setText("Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            TextView adviceTextTV = (TextView) findViewById(R.id.adviceText);
            adviceTextTV.setText("Normal");
        } else if (bmi > 24.9 && bmi <= 29.9) {
            TextView adviceTextTV = (TextView) findViewById(R.id.adviceText);
            adviceTextTV.setText("Overweight");
        } else {
            TextView adviceTextTV = (TextView) findViewById(R.id.adviceText);
            adviceTextTV.setText("Obese");
        }

    }
}
