package com.example.ui_training;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText loginEditText;
    EditText passEditText;
    EditText checkPassEditText;
    EditText nameEditText;
    EditText familyEditText;
    EditText aboutEditText;
    RadioButton sexRadioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        CheckBox checkBoxCondition = findViewById(R.id.checkBoxCondition);
        Button registerButton = findViewById(R.id.register_btn);
        Button backBtn = findViewById(R.id.back_register);
        loginEditText = findViewById(R.id.register_login);
        passEditText = findViewById(R.id.register_pass);
        checkPassEditText = findViewById(R.id.register_check_pass);
        nameEditText = findViewById(R.id.register_name);
        familyEditText = findViewById(R.id.register_family);
        aboutEditText = findViewById(R.id.register_about);
        sexRadioBtn = findViewById(((RadioGroup) findViewById(R.id.sex_choise)).getCheckedRadioButtonId());

        checkBoxCondition.setOnClickListener(view -> registerButton.setEnabled(!registerButton.isEnabled()));
        registerButton.setOnClickListener(view -> sendIntent());
        backBtn.setOnClickListener(view -> finish());
    }

    private void sendIntent() {
        boolean errors = false;
        String login = loginEditText.getText().toString().trim();
        String pass = passEditText.getText().toString().trim();
        String checkPass = checkPassEditText.getText().toString().trim();

        if (login.isEmpty()) {
            errors = true;
            loginEditText.setError("Не должно быть пустым!");
        }
        if (login.length() < 4) {
            errors = true;
            loginEditText.setError("Слишком короткий!");
        }

        if (pass.isEmpty()) {
            errors = true;
            passEditText.setError("Не должно быть пустым!");
        }
        if (pass.length() < 8) {
            errors = true;
            passEditText.setError("Слишком короткий!");
        }

        if (!pass.equals(checkPass)) {
            errors = true;
            checkPassEditText.setError("Не совпадает!");
        }

        if (errors) {
            return;
        }

        Intent infoIntent = new Intent(this, InfoActivity.class);
        infoIntent.putExtra("login", login);
        infoIntent.putExtra("pass", pass);
        infoIntent.putExtra("name", nameEditText.getText().toString().trim());
        infoIntent.putExtra("family", familyEditText.getText().toString().trim());
        infoIntent.putExtra("about", aboutEditText.getText().toString().trim());
        infoIntent.putExtra("sex", sexRadioBtn.getText().toString());

        startActivity(infoIntent);
    }

}
