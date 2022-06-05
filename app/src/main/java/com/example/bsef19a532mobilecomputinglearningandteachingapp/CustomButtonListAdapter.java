package com.example.bsef19a532mobilecomputinglearningandteachingapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;

public class CustomButtonListAdapter extends ArrayAdapter {
    Activity context;
    String[] btn_list;
    LayoutInflater inflater;

    public CustomButtonListAdapter(Activity context, String[] btn_list) {
        super(context, R.layout.layout_custom_list_view, btn_list);
        this.btn_list = btn_list;
        this.context = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = context.getLayoutInflater();
        View new_view = inflater.inflate(R.layout.layout_custom_list_view, null);
        Button btn = new_view.findViewById(R.id.btn_item);
        btn.setText(btn_list[i]);
        return new_view;
    }
}
