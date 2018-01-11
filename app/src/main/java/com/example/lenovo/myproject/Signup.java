package com.example.lenovo.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2,et3,et4;
    RadioGroup rg;
    RadioButton rb1,rb2;
    Dtabase_helper dh;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Intent i = getIntent();
        et1 = (EditText)findViewById(R.id.user_name);
        et2 = (EditText)findViewById(R.id.password);
        et3 = (EditText)findViewById(R.id.phone);
        et4 = (EditText)findViewById(R.id.email);
        rg =(RadioGroup)findViewById(R.id.rg);
         rb1 = (RadioButton)findViewById(R.id.rb1);
          rb2 = (RadioButton)findViewById(R.id.rb2);
        btn = (Button)findViewById(R.id.signup);
        dh= new Dtabase_helper(this);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String username= et1.getText().toString();
        String password= et2.getText().toString();
        String phone= et3.getText().toString();
        String email=et4.getText().toString();
        // if(rg.getCheckedRadioButtonId()!=-1)
        String utype = " ";
        if(R.id.rb1 == rg.getCheckedRadioButtonId()){
            utype = "Company";
        }
        else if(R.id.rb2 == rg.getCheckedRadioButtonId()){
            utype = "Freelancer";
        }
        //String utype = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();

        boolean is_inserted= dh.insert_data(username,password,phone,email,utype);
        if(is_inserted == true){
            Toast.makeText(Signup.this, "Signed up" , Toast.LENGTH_LONG).show();
            et1.setText(" ");
            et2.setText("");
            et3.setText(" ");
            et4.setText(" ");
            if(R.id.rb1==rg.getCheckedRadioButtonId()){
                rb1.setChecked(false);
            }
           else if(R.id.rb2==rg.getCheckedRadioButtonId()){
                rb2.setChecked(false);
            }
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
        else {
            Toast.makeText(Signup.this, "Not signed up", Toast.LENGTH_LONG).show();
        }
    }


}

