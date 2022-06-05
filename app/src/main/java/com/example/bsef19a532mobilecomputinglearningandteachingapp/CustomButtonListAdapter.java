package com.example.bsef19a532mobilecomputinglearningandteachingapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class CustomButtonListAdapter extends ArrayAdapter {
    Activity context;
    ArrayList<String> data;
    LayoutInflater inflater;

    public CustomButtonListAdapter(Activity context, ArrayList<String> data) {
        super(context, R.layout.layout_custom_list_view, data);
        this.data = data;
        this.context = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = context.getLayoutInflater();
        View new_view = inflater.inflate(R.layout.layout_custom_list_view, null);
        Button btn = new_view.findViewById(R.id.btn_item);
        btn.setText(data.get(i));
        btn.setFocusable(false);
        btn.setClickable(false);
        btn.setFocusableInTouchMode(false);
        return new_view;
    }
}
