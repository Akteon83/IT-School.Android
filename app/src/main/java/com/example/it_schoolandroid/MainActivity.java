package com.example.it_schoolandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextA;
    EditText editTextB;
    EditText editTextC;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.edit_text_a);
        editTextB = findViewById(R.id.edit_text_b);
        editTextC = findViewById(R.id.edit_text_c);
        answer = findViewById(R.id.answer);
    }

    public void get_ans(View view) {
        boolean aExists = !(editTextA.getText().toString().isEmpty());
        boolean bExists = !(editTextB.getText().toString().isEmpty());
        boolean cExists = !(editTextC.getText().toString().isEmpty());
        if (aExists && bExists && cExists) {
            double a = Double.parseDouble(editTextA.getText().toString());
            double b = Double.parseDouble(editTextB.getText().toString());
            double c = Double.parseDouble(editTextC.getText().toString());
            double d = b * b - 4 * a * c;
            if (d > 0) {
                //double x1 = (-b - Math.sqrt(d)) / (2 * a);
                String x1 = String.format("%.4f", (-b - Math.sqrt(d)) / (2 * a));
                //double x2 = (-b + Math.sqrt(d)) / (2 * a);
                String x2 = String.format("%.4f", (-b + Math.sqrt(d)) / (2 * a));
                answer.setText("x₁ = " + x1 +"  x₂ = " + x2);
            } else if (d == 0) {
                double x1 = (-b / (2 * a));
                answer.setText("x = " + x1);
            } else {
                answer.setText("Решений нет");
            }
        }
    }
}