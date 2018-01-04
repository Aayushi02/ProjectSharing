package com.example.lenovo.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Lenovo on 20-06-2017.
 */

class MyAdaptor extends BaseAdapter implements View.OnClickListener {
    ArrayList<String> name;
    ArrayList<String> desc;
    TextView tv1,tv2;
    Button btn;
    Context context;
    Mydatabse mydatabase;
    public MyAdaptor(Context context, ArrayList<String> name, ArrayList<String> desc, String s){
     this.context = context;
        this.name=name;
        this.desc=desc;
        mydatabase = new Mydatabse(this.context,s);
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

        view = LayoutInflater.from(context).inflate(R.layout.layout,viewGroup,false);
        tv1 = (TextView) view.findViewById(R.id.name);
        tv2 = (TextView) view.findViewById(R.id.desc);
        btn = (Button) view.findViewById(R.id.btn);
        tv1.setText(name.get(i));
        tv2.setText(desc.get(i));
        btn.setOnClickListener(this);
        return view;
    }
public static int count = 5;
    @Override
    public void onClick(View view) {
        String name = tv1.getText().toString();
        String desc = tv2.getText().toString();
        boolean is_inserted = mydatabase.insert_data(name,desc);
       if(is_inserted==false){
Toast.makeText(MyAdaptor.this.context,"Not joined",Toast.LENGTH_SHORT).show();
        }
        else{
          // if(count==0)
           btn.setEnabled(false);
          // else
            //   count--;
       }
    }
}
