package com.example.bsef19a532mobilecomputinglearningandteachingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_learn;
    Button btn_exam;
    Button btn_repo;
    Button btn_list_view;
    String repo_url = "https://github.com/BSEF19A532/BSEF19A532-Mobile-Computing-Learning-And-Teaching-App";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_learn = findViewById(R.id.btn_learn);
        btn_exam = findViewById(R.id.btn_exam);
        btn_repo = findViewById(R.id.btn_repo);

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
                Intent intent = Data.exam_intent( MainActivity.this, Exam.class, 0 );
                startActivity(intent);
            }
        });

        // repository button
        btn_repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(repo_url));
                startActivity(intent);
            }
        });

        // list view button
        btn_list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, ListViewActivity.class );
                startActivity(intent);
            }
        });
    }
}