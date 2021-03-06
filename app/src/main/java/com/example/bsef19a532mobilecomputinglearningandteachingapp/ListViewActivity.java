package com.example.bsef19a532mobilecomputinglearningandteachingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView lst_view;
    ArrayAdapter<String> adapter;
    ArrayList<String> data;


    Button btn;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        data = new ArrayList<String>();
        data.add("Khalil");
        data.add("Abdullah");
        data.add("Abdullah");

        lst_view = findViewById(R.id.lst_view);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        lst_view.setAdapter(adapter);

        btn = findViewById(R.id.button);
        input = findViewById(R.id.input);
    }
}