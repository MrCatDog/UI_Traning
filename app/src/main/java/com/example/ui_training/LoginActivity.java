package com.example.ui_training;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText passEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button backBtn = findViewById(R.id.back_login);
        Button loginBtn = findViewById(R.id.login_btn);
        loginEditText = findViewById(R.id.login_edittext);
        passEditText = findViewById(R.id.pass_edittext);
        backBtn.setOnClickListener(view -> finish());
        loginBtn.setOnClickListener(view -> {
            sendIntent();
        });
    }

    private void sendIntent() {
        boolean errors = false;
        String login = loginEditText.getText().toString().trim();
        String pass = passEditText.getText().toString().trim();
        if (login.isEmpty()) {
            errors = true;
            loginEditText.setError(getString(R.string.error_empty));
        }
        if (pass.isEmpty()) {
            errors = true;
            passEditText.setError(getString(R.string.error_empty));
        }
        if (errors) {
            return;
        }
        Intent infoIntent = new Intent(this, InfoActivity.class);
        infoIntent.putExtra(InfoActivity.LOGIN, login);
        infoIntent.putExtra(InfoActivity.PASSWORD, pass);
        startActivity(infoIntent);
    }
}
