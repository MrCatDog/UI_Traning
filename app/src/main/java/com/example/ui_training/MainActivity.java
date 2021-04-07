package com.example.ui_training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button enterBtn;
    private Button registerBtn;
    private Button aboutProg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterBtn = findViewById(R.id.enter_btn);
        registerBtn = findViewById(R.id.register_btn_main);
        aboutProg = findViewById(R.id.about_btn);

        enterBtn.setOnClickListener(view -> {
            Intent enterIntent = new Intent(this, LoginActivity.class);
            startActivity(enterIntent);
        });
        registerBtn.setOnClickListener(view -> {
            Intent registerIntent = new Intent(this, RegisterActivity.class);
            startActivity(registerIntent);
        });
        aboutProg.setOnClickListener(view -> {
            Intent aboutIntent = new Intent(Intent.ACTION_VIEW);
            aboutIntent.setData(Uri.parse("https://developer.android.com/guide/components/intents-filters"));
            if (aboutIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(aboutIntent);
            }
        });
    }
}