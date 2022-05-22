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
        txt = findViewById(R.id.learning_text);
        btn_next = findViewById(R.id.btn_next);
        btn_prev = findViewById(R.id.btn_prev);

        // next button
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_index++;
                img.setImageResource( Data.images[current_index] );
                txt.setText( "This is a " + Data.contents[current_index] );

                if ( ! btn_prev.isShown() && current_index > 0 ) {
                    btn_prev.setVisibility(View.VISIBLE);
                }

                if ( current_index >= Data.images.length - 1 ) {
                    btn_next.setVisibility(View.INVISIBLE);
                }
            }
        });

        // previous button
        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_index--;
                img.setImageResource( Data.images[current_index] );
                txt.setText( Data.contents[current_index] );

                if ( ! btn_next.isShown() && current_index < Data.images.length - 1 ) {
                    btn_next.setVisibility(View.VISIBLE);
                }

                if ( current_index <= 0 ) {
                    btn_prev.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}