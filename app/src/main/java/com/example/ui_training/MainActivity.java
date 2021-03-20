package com.example.ui_training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button enterBtn = findViewById(R.id.enter_btn);
        Button registerBtn = findViewById(R.id.register_btn_main);
        Button aboutProg = findViewById(R.id.about_btn);
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
            startActivity(aboutIntent);
        });
    }
}