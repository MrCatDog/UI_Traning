package com.example.ui_training;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    public static final String LOGIN = "login";
    public static final String PASSWORD = "pass";
    public static final String NAME = "name";
    public static final String FAMILY = "family";
    public static final String SEX = "sex";
    public static final String ABOUT = "about";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView login = findViewById(R.id.info_login);
        TextView pass = findViewById(R.id.info_pass);
        TextView name = findViewById(R.id.info_name);
        TextView family = findViewById(R.id.info_family);
        TextView sex = findViewById(R.id.info_sex);
        TextView about = findViewById(R.id.info_about);
        Button backBtn = findViewById(R.id.back_info);

        backBtn.setOnClickListener(view -> finish());
        Intent intent = getIntent();

        login.append(intent.getStringExtra(LOGIN));
        pass.append(intent.getStringExtra(PASSWORD));
        if (intent.getStringExtra(NAME) != null) {
            name.append(intent.getStringExtra(NAME));
        }
        if (intent.getStringExtra(FAMILY) != null) {
            family.append(intent.getStringExtra(FAMILY));
        }
        if (intent.getStringExtra(SEX) != null) {
            sex.append(intent.getStringExtra(SEX));
        }
        if (intent.getStringExtra(ABOUT) != null) {
            about.append(intent.getStringExtra(ABOUT));
        }
    }
}