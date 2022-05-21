package com.example.bsef19a532mobilecomputinglearningandteachingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Learning extends AppCompatActivity {

    int current_index;
    int[] images = {
            R.drawable.tree,
            R.drawable.fire,
            R.drawable.water,
            R.drawable.rock,
    };
    String[] contents = {
            "This is a tree",
            "This is fire",
            "This is a water",
            "This is a stone"
    };
    ImageView img;
    TextView txt;
    Button btn_next;
    Button btn_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);


    }
}