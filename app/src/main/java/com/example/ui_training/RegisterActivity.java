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

    private EditText loginEditText;
    private EditText passEditText;
    private EditText checkPassEditText;
    private EditText nameEditText;
    private EditText familyEditText;
    private EditText aboutEditText;
    private RadioGroup sexRadioGroup;

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
        sexRadioGroup = findViewById(R.id.sex_choise);

        checkBoxCondition.setOnClickListener(view -> registerButton.setEnabled(!registerButton.isEnabled()));
        registerButton.setOnClickListener(view -> sendIntent());
        backBtn.setOnClickListener(view -> finish());
    }

    private void sendIntent() {
        boolean errors = false;
        String login = loginEditText.getText().toString().trim();
        String pass = passEditText.getText().toString().trim();
        String checkPass = checkPassEditText.getText().toString().trim();
        String name = nameEditText.getText().toString().trim();
        String family = familyEditText.getText().toString().trim();

        if (login.isEmpty()) {
            errors = true;
            loginEditText.setError(getString(R.string.error_empty));
        } else {
            if (login.length() < 4) {
                errors = true;
                loginEditText.setError(getString(R.string.error_too_short));
            }
        }

        if (pass.isEmpty()) {
            errors = true;
            passEditText.setError(getString(R.string.error_empty));
        } else {
            if (pass.length() < 8) {
                errors = true;
                passEditText.setError(getString(R.string.error_too_short));
            }
        }

        if(checkPass.isEmpty()) {
            errors = true;
            checkPassEditText.setError(getString(R.string.error_empty));
        } else {
            if (!pass.equals(checkPass)) {
                errors = true;
                checkPassEditText.setError(getString(R.string.error_pass_dont_match));
            }
        }

        if (name.isEmpty()) {
            errors = true;
            nameEditText.setError(getString(R.string.error_empty));
        }

        if (family.isEmpty()) {
            errors = true;
            familyEditText.setError(getString(R.string.error_empty));
        }

        if (errors) {
            return;
        }

        Intent infoIntent = new Intent(this, InfoActivity.class);
        infoIntent.putExtra(InfoActivity.LOGIN, login);
        infoIntent.putExtra(InfoActivity.PASSWORD, pass);
        infoIntent.putExtra(InfoActivity.NAME, name);
        infoIntent.putExtra(InfoActivity.FAMILY, family);
        infoIntent.putExtra(InfoActivity.ABOUT, aboutEditText.getText().toString().trim());
        infoIntent.putExtra(InfoActivity.SEX, ((RadioButton) findViewById(sexRadioGroup.getCheckedRadioButtonId())).getText().toString());

        startActivity(infoIntent);
    }

}
