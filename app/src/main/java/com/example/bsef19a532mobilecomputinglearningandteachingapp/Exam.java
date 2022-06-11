package com.example.bsef19a532mobilecomputinglearningandteachingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Exam extends AppCompatActivity implements View.OnClickListener {

    int img;
    String correct_option = "";
    String wrong_option_1 = "";
    String wrong_option_2 = "";

    ImageView imgView;
    Button option_1;
    Button option_2;
    Button option_3;
    ListView btns;

    Button btn_next;

    int score;
    TextView score_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        // get the intent
        Intent intent = getIntent();
        img = intent.getIntExtra("image", 0);
        score = intent.getIntExtra("score", 0);
        // get data from intent
        correct_option = intent.getStringExtra("correct_option");
        wrong_option_1 = intent.getStringExtra("wrong_option_1");
        wrong_option_2 = intent.getStringExtra("wrong_option_2");

        score_text = findViewById(R.id.score_text);
        score_text.setText("Score: " + score);
        option_1 = findViewById(R.id.option_1);
        option_2 = findViewById(R.id.option_2);
        option_3 = findViewById(R.id.option_3);
        btns = findViewById(R.id.exam_btn_lst);

        imgView = findViewById(R.id.image);
        imgView.setImageResource(img);

        ArrayList<String> items = new ArrayList<String>();
        items.add( correct_option );
        items.add( wrong_option_1 );
        items.add( wrong_option_2 );

        ArrayList<String> random_items = new ArrayList<String>();

        while ( items.size() > 0 ) {
            Random rand = new Random();
            int index = rand.nextInt( items.size() );
            random_items.add( items.get(index) );
            items.remove(index);
        }

        CustomButtonListAdapter adapter = new CustomButtonListAdapter(this, random_items);
        btns.setFocusable(true);
        btns.setAdapter(adapter);

        btns.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("item", "clicked");
                Button btn = (Button) view.findViewById(R.id.btn_item);
                String value = btn.getText().toString();
                if ( value.equals( correct_option ) ) {
                    btn.setText("correct");
                    score++;
                    score_text.setText("Score: " + score);
                } else {
                    btn.setText("wrong");
                }
            }
        });

        option_1.setText(random_items.get(0));
        option_2.setText(random_items.get(1));
        option_3.setText(random_items.get(2));

        option_1.setOnClickListener(this);
        option_2.setOnClickListener(this);
        option_3.setOnClickListener(this);

        btn_next = findViewById(R.id.btn_next_question);

        if ( Data.covered_indexes.size() == Data.images.length ) {
            btn_next.setText( "Back to Home" );
        }

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( Data.covered_indexes.size() != Data.images.length ) {
                    Intent intent = Data.exam_intent( Exam.this, Exam.class, score );
                    startActivity(intent);
                } else {
                    Intent intent = new Intent( Exam.this, MainActivity.class );
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    Data.covered_indexes.clear();
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        img = savedInstanceState.getInt("image");
        correct_option = savedInstanceState.getString("correct_option");
        wrong_option_1 = savedInstanceState.getString("wrong_option_1");
        wrong_option_2 = savedInstanceState.getString("wrong_option_2");
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        String value = btn.getText().toString();
        if ( value.equals( correct_option ) ) {
            btn.setText("correct");
            score++;
            score_text.setText("Score: " + score);
        } else {
            btn.setText("wrong");
        }
    }

}