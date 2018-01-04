package com.example.lenovo.myproject;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Fragment_tab2 extends Fragment {
ListView lv;
    Mydatabse mydatabase;
    String s;
    public Fragment_tab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_fragment_tab2,container,false);
        lv = (ListView) v.findViewById(R.id.lv);
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> desc = new ArrayList<String>();
        s =getArguments().getString("uname");
        mydatabase = new Mydatabse(this.getActivity().getBaseContext(),s);
        Cursor c= null;
                c=mydatabase.getAllData();

        if(c == null || c.getCount() == 0){
            Toast.makeText(Fragment_tab2.this.getActivity(),"No project joined",Toast.LENGTH_SHORT).show();
        }
        else{
            while (c.moveToNext()){
                name.add(c.getString(0));
               // desc.add(c.getString(2));
                Project_adaptor project_adaptor= new Project_adaptor(getActivity().getBaseContext(),name);
                lv.setAdapter(project_adaptor);
            }
        }
        return v;
    }
}




