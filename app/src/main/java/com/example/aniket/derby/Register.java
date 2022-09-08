package com.example.aniket.derby;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
    EditText email;
    EditText password;
    EditText confirm_password;
    Button register;
    Button nav_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText) findViewById(R.id.r_email);
        password = (EditText) findViewById(R.id.r_password);
        confirm_password = (EditText) findViewById(R.id.r_password_confirm);
        register = (Button) findViewById(R.id.button_register);
        nav_login = (Button) findViewById(R.id.button_nav_login);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_email  = email.getText().toString();
                String s_password = password.getText().toString();
                String s_confirm_password = confirm_password.getText().toString();

                if(s_email.isEmpty()||!s_email.contains("@")||!s_email.contains("."))
                {
                    email.setError("Enter valid Email");
                }
                else if(s_password.length()<6)
                {
                    password.setError("Minimum password length: 6");
                }
                else if(s_confirm_password.isEmpty())
                {
                    confirm_password.setError("Re-enter password");
                }
                else if(!s_password.equals(s_confirm_password)){
                    confirm_password.setError("Re-enter correct password");
                }
                else {
                    Toast.makeText(Register.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                }
            }
        });

        nav_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
