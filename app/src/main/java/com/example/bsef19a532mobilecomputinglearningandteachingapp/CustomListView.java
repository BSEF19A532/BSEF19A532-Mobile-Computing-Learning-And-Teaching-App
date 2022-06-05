package com.example.bsef19a532mobilecomputinglearningandteachingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class CustomListView extends BaseAdapter {
    Context context;
    Button[] btn_list;
    LayoutInflater inflater;

    public CustomListView(Context context, Button[] btn_list) {
        this.context = context;
        this.btn_list = btn_list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return btn_list.length;
    }

    @Override
    public Object getItem(int position) {
        return btn_list[position];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.layout_custom_list_view, null);
        Button btn = view.findViewById(R.id.btn_item);
        btn.setText("It is working");
        return null;
    }
}
