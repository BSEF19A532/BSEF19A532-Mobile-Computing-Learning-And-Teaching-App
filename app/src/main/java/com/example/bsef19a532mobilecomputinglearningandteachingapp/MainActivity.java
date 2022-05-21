package com.example.bsef19a532mobilecomputinglearningandteachingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_learn;
    Button btn_exam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_learn = findViewById(R.id.btn_learn);
        btn_exam = findViewById(R.id.btn_exam);

        // move to the learning activity
        btn_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Learning.class);
                startActivity(intent);
            }
        });

        // move to the exam activity
        btn_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exam.class);
                startActivity(intent);
            }
        });
    }
}