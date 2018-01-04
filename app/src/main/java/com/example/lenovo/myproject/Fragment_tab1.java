package com.example.lenovo.myproject;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Fragment_tab1 extends Fragment {

String s;

    public Fragment_tab1()  {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= LayoutInflater.from(getContext()).inflate(R.layout.fragment_fragment_tab1,container,false);
       ListView lv = (ListView) v.findViewById(R.id.listview);
        Database_projects dp = new Database_projects(getActivity());
        s = getArguments().getString("uname");
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> desc = new ArrayList<String>();
       Cursor c = dp.getAllData();
        if(c.getCount()==0){
            name.add("Empty");
            desc.add("Empty");

            MyAdaptor myadaptor = new MyAdaptor(getActivity().getBaseContext(),name,desc,s);
            lv.setAdapter( myadaptor);
        }
        else {
            while (c.moveToNext()) {
                name.add(c.getString(0));
                desc.add(c.getString(1));
                MyAdaptor myadaptor = new MyAdaptor(getActivity().getBaseContext(),name,desc,s);
                lv.setAdapter( myadaptor);
            }
        }

        return v;
    }



}
