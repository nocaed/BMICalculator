package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // initial set up
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI Calculator");
        // fetch all necessary views
        Button calcBtn = findViewById(R.id.calcBtn);
        Button adviceBtn = findViewById(R.id.adviceBtn);
        final EditText weightET = findViewById(R.id.weightET);
        final EditText heightET = findViewById(R.id.heightET);
        final TextView bmiResultTV = findViewById(R.id.bmiResultTV);
        final RadioButton customaryRB = findViewById(R.id.customaryRB);
        final RadioButton metricRB = findViewById(R.id.metricRB);
        // event handlers
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calculate the bmi and display it to the user
                DecimalFormat formatter = new DecimalFormat("0.##");

                bmiResultTV.setText(formatter.format(calculateBMI(weightET, heightET, customaryRB, metricRB)));
            }
        });

        adviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bmiResultTV.length() < 1) {
                    Toast.makeText(getApplicationContext(), "Please enter BMI first.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Double bmi = new Double(bmiResultTV.getText().toString());
                Intent adviceIntent = new Intent(MainActivity.this, AdviceActivity.class);
                adviceIntent.putExtra("bmi", bmi);
                startActivity(adviceIntent);
            }
        });
    }

    /**
     * Calculates the BMI based on input.
     * @param w Weight
     * @param h Height
     * @param c Customary units
     * @param m Metric units
     * @return The calculated BMI
     */
    protected double calculateBMI(EditText w, EditText h, RadioButton c,
                                  RadioButton m) {
        double bmi = 0.0;
        try {
            BMICalculator calculator;
            if (c.isChecked())
                calculator = new BMICalculator(CalculationMode.CUSTOMARY);
            else if (m.isChecked())
                calculator = new BMICalculator(CalculationMode.METRIC);
            else
                throw new Exception("Error with radio buttons.");
            bmi = calculator.calculateBMI(Double.parseDouble(w.getText().toString()),
                                          Double.parseDouble(h.getText().toString()));
        }
        catch(Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
        return bmi;
    }
}
