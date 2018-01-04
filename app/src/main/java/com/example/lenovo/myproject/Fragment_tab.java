package com.example.lenovo.myproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;


public class Fragment_tab extends Fragment {
   TabLayout t1;
    ViewPager vp;
    public static final int tab_count=2;
    public static final String [] items= new String[]{
            "All Projects", "My Project"
    };
    String strtext;
    Bundle b = new Bundle();
    public Fragment_tab() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        strtext = getArguments().getString("uname");
        View v= LayoutInflater.from(getContext()).inflate(R.layout.fragment_fragment_tab,container,false);
        //Bundle b = getIntent.getExtras();

        b.putString("uname",strtext);

        t1= (TabLayout) v.findViewById(R.id.tablayout);
        vp=(ViewPager) v.findViewById(R.id.viewpage);
        vp.setAdapter(new Tab_Adaptor(getChildFragmentManager()));
       vp.post(new Runnable() {
           @Override
           public void run() {
               t1.setupWithViewPager(vp);
           }
       });
        // Inflate the layout for this fragment
        return v;
    }
    class Tab_Adaptor extends FragmentPagerAdapter {

        public Tab_Adaptor(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position)
            {
                case 0:
                    Fragment_tab1 f1= null;

                        f1 = new Fragment_tab1();
                        f1.setArguments(b);
                    return f1;


                case 1:
                 Fragment_tab2 f2 = new Fragment_tab2();
                    f2.setArguments(b);
                    return f2;


            }
            return  null;
        }

        @Override
        public int getCount() {
            return tab_count;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return items[position];
        }
    }


}
