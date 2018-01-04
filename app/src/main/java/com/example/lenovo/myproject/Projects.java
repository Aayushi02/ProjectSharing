package com.example.lenovo.myproject;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Projects extends AppCompatActivity implements View.OnClickListener {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        Intent i = getIntent();
        String username = i.getStringExtra("username");
        Bundle bundle = new Bundle();
        bundle.putString("uname",username);
   btn = (Button)findViewById(R.id.logout);
        btn.setOnClickListener(this);
        FragmentManager fm;

        android.support.v4.app.FragmentTransaction ft;
        fm= getSupportFragmentManager();
        Fragment_tab fragment_tab = new Fragment_tab();
        fragment_tab.setArguments(bundle);
        ft= fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment_tab).commit();
    }

    @Override
    public void onClick(View view) {
        finish();
        Intent i =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
