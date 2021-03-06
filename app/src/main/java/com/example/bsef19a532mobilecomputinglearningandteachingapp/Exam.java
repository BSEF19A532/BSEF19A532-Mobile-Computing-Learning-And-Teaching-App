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

        // select score text
        score_text = findViewById(R.id.score_text);
        score_text.setText("Score: " + score);
        //  select options
        option_1 = findViewById(R.id.option_1);
        option_2 = findViewById(R.id.option_2);
        option_3 = findViewById(R.id.option_3);
        btns = findViewById(R.id.exam_btn_lst);

        // select image view
        imgView = findViewById(R.id.image);
        imgView.setImageResource(img);

        // create array list of all options
        ArrayList<String> items = new ArrayList<String>();
        items.add( correct_option );
        items.add( wrong_option_1 );
        items.add( wrong_option_2 );

        ArrayList<String> random_items = new ArrayList<String>();

        // randomize the options
        while ( items.size() > 0 ) {
            Random rand = new Random();
            int index = rand.nextInt( items.size() );
            random_items.add( items.get(index) );
            items.remove(index);
        }

        // adapt the randomized array list
        CustomButtonListAdapter adapter = new CustomButtonListAdapter(this, random_items);
        btns.setFocusable(true);
        btns.setAdapter(adapter);

        // set on click event listener
        btns.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // typecast to button
                Button btn = (Button) view.findViewById(R.id.btn_item);
                // get the value of the button
                String value = btn.getText().toString();
                // check if value equals the correct value
                if ( value.equals( correct_option ) ) {
                    // set the button text to correct
                    btn.setText("correct");
                    // increment the score
                    score++;
                    // show the updated score to the user
                    score_text.setText("Score: " + score);
                } else {
                    // inform the user that the option is wrong
                    btn.setText("wrong");
                }
            }
        });

        // set text to the options
        option_1.setText(random_items.get(0));
        option_2.setText(random_items.get(1));
        option_3.setText(random_items.get(2));

        // set click event listeners to the options
        option_1.setOnClickListener(this);
        option_2.setOnClickListener(this);
        option_3.setOnClickListener(this);
        // select the next button
        btn_next = findViewById(R.id.btn_next_question);
        // if the current question is last then button text should signal back to home
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