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

    private Button backBtn;
    private TextView about;
    private TextView sex;
    private TextView family;
    private TextView name;
    private TextView pass;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        login = findViewById(R.id.info_login);
        pass = findViewById(R.id.info_pass);
        name = findViewById(R.id.info_name);
        family = findViewById(R.id.info_family);
        sex = findViewById(R.id.info_sex);
        about = findViewById(R.id.info_about);
        backBtn = findViewById(R.id.back_info);

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