package com.example.ui_training;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText passEditText;
    private Button loginBtn;
    private Button backBtn;

    String loginErrorText;
    String passErrorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backBtn = findViewById(R.id.back_login);
        loginBtn = findViewById(R.id.login_btn);
        loginEditText = findViewById(R.id.login_edittext);
        passEditText = findViewById(R.id.pass_edittext);
        backBtn.setOnClickListener(view -> finish());

        loginErrorText = getString(R.string.error_empty);
        passErrorText = getString(R.string.error_empty);

        loginBtn.setOnClickListener(view -> {
            sendIntent();
        });
    }

    private void sendIntent() {
        loginEditText.setError(null);
        passEditText.setError(null);

        boolean errors = false;
        String login = loginEditText.getText().toString().trim();
        String pass = passEditText.getText().toString().trim();

        if (login.isEmpty()) {
            errors = true;
            loginEditText.setError(loginErrorText);
        }
        if (pass.isEmpty()) {
            errors = true;
            passEditText.setError(passErrorText);
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
