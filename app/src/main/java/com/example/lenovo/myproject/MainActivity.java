package com.example.lenovo.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_user, et_password;
    Button login, signup;
    RadioGroup rg;
    TextView tv;
    Dtabase_helper db = new Dtabase_helper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_user = (EditText) findViewById(R.id.user_name);
        et_password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        signup = (Button) findViewById(R.id.signup);
        tv = (TextView) findViewById(R.id.tv);
        signup.setOnClickListener(this);
        login.setOnClickListener(this);
        Intent i = new Intent();
        i = getIntent();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signup) {
            Intent intent = new Intent(MainActivity.this, Signup.class);
            startActivity(intent);
        } else if (view.getId() == R.id.login) {
            String uname = et_user.getText().toString();
            String pass = et_password.getText().toString();
            String password = db.searchpass(uname);
            String str = " C";
            et_password.setText(" ");
            et_user.setText(" ");
          /* if (R.id.rb1 == rg.getCheckedRadioButtonId()) {
                str = "Company";
            } else if (R.id.rb2 == rg.getCheckedRadioButtonId()) {
                str = "Freelancer";
           }*/

            // String str = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            str= db.searchutype(uname);
            tv.setText(str);
            if (pass.equals(password)) {

                if (str.equals("Company")) {
                    Intent intent = new Intent(MainActivity.this, Post_Project.class);
                    intent.putExtra("username", uname);
                    startActivity(intent);

                } else if (str.equals("Freelancer")) {
                    Intent intent = new Intent(MainActivity.this, Projects.class);
                    intent.putExtra("username", uname);
                    startActivity(intent);

                }
            }
            else {
                Toast.makeText(MainActivity.this, "Password and username do not match", Toast.LENGTH_SHORT).show();
            }

        }
    }
}





