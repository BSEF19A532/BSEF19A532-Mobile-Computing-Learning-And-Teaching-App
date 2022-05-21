package com.example.bsef19a532mobilecomputinglearningandteachingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
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

        current_index = 0;

        img = findViewById(R.id.image_learning);
        btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_index++;
                img.setImageResource( images[current_index] );
                if ( current_index >= images.length - 1 ) {
                    btn_next.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}