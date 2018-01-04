package com.example.lenovo.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lenovo on 27-06-2017.
 */

public class Project_adaptor extends BaseAdapter {
    ArrayList<String> name;
    TextView tv1;
    Context context;
    public Project_adaptor(Context context,ArrayList<String>name){
        this.name=name;
        this.context = context;
    }
    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int i) {
        return name.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.project_layout,viewGroup,false);
        tv1 = (TextView) view.findViewById(R.id.name);
        tv1.setText(name.get(i));
        return view;
    }
}
