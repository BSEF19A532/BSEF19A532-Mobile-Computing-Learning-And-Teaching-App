package com.example.bsef19a532mobilecomputinglearningandteachingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Exam extends AppCompatActivity {

    int img;
    String correct_option = "";
    String wrong_option_1 = "";
    String wrong_option_2 = "";

    ImageView imgView;
    Button option_1;
    Button option_2;
    Button option_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        option_1 = findViewById(R.id.option_1);
        option_2 = findViewById(R.id.option_2);
        option_3 = findViewById(R.id.option_3);

        imgView = findViewById(R.id.image);

        if ( img == 0 ) {
            img = R.drawable.tree;
        }

        if ( correct_option.isEmpty() ) {
            correct_option = "Tree";
        }

        if ( wrong_option_1.isEmpty() ) {
            wrong_option_1 = "Rock";
        }

        if ( wrong_option_2.isEmpty() ) {
            wrong_option_2 = "Water";
        }

        imgView.setImageResource(img);
        option_1.setText(correct_option);
        option_2.setText(wrong_option_1);
        option_3.setText(wrong_option_2);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        img = savedInstanceState.getInt("image");
        correct_option = savedInstanceState.getString("correct_option");
        wrong_option_1 = savedInstanceState.getString("wrong_option_1");
        wrong_option_2 = savedInstanceState.getString("wrong_option_2");
    }
}