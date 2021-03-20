package com.example.ui_training;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {
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
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            login.append(extras.getCharSequence("login"));
            pass.append(extras.getCharSequence("pass"));
            if(extras.containsKey("name")) {
                name.append(extras.getCharSequence("name"));
            }
            if(extras.containsKey("family")) {
                family.append(extras.getCharSequence("family"));
            }
            if(extras.containsKey("sex")) {
                sex.append(extras.getCharSequence("sex"));
            }
            if(extras.containsKey("about")) {
                about.append(extras.getCharSequence("about"));
            }
        }
    }
}