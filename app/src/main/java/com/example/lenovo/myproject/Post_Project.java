package com.example.lenovo.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Post_Project extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2;
    Button btn1,btn2;
    TextView tv;
    Database_projects dp = new Database_projects(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__project);
        Intent intent = getIntent();
        String s= intent.getStringExtra("username");
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        btn1=(Button)findViewById(R.id.logout);
        btn2=(Button)findViewById(R.id.post);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.logout){
           finish();
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
        else if(view.getId()== R.id.post){
            boolean is_insert = dp.insert_data(et1.getText().toString(),et2.getText().toString());
            if(is_insert == true){
                Toast.makeText(Post_Project.this,"Project posted",Toast.LENGTH_SHORT).show();
                et1.setText(" ");
                et2.setText(" ");
            }
            else{
                Toast.makeText(Post_Project.this,"Project not posted",Toast.LENGTH_SHORT).show();
            }
        }
    }
}

