package com.rvkumar.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    final String uName= "ind.vijayworldz@gmail.com";
    final String pwd = "born2win";

    boolean userStatus = false;
    boolean passwordStatus = false;
    Button login, clear;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(this,LoginPage.class);
        login = (Button) findViewById(R.id.login);
        clear = (Button) findViewById(R.id.clear);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login.setEnabled(false);
        login.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                intent.putExtra("userName", username.getText().toString());
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        clear.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                username.setText("");
                password.setText("");
            }
        });

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println(username.getText().toString());
                System.out.println(uName);
                System.out.println(uName.equals(username.getText().toString()));
                if (uName.equals(username.getText().toString())) {
                    userStatus = true;
                } else {
                    userStatus = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (userStatus && passwordStatus) {
                    login.setEnabled(true);
                } else {
                    login.setEnabled(false);
                }
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(pwd.equals(password.getText().toString())){
                    passwordStatus = true;
                }else{
                    passwordStatus = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (userStatus && passwordStatus) {
                    login.setEnabled(true);
                } else {
                    login.setEnabled(false);
                }
            }
        });
    }
}
