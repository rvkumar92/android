package com.rvkumar.login;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginPage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");

        TextView loginView = (TextView) findViewById(R.id.loginview);
        loginView.setTextSize(25);
        loginView.setText("Welcome !" + userName);
        loginView.setTextColor(Color.GREEN);
        Button back = (Button) findViewById(R.id.back);
        back.setText("Back");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });

    }
}
