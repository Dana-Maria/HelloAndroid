package com.example.loginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextEmail;
    private EditText mEditTextPhone;
    private TextView mTextViewResult;
    private CheckBox mCheckedBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEditTextEmail = findViewById(R.id.edit_text_email_address);
        mEditTextPhone = findViewById(R.id.edit_text_phone);
        mTextViewResult = findViewById(R.id.text_view_result);
        mCheckedBox = findViewById(R.id.checked);
    }

    private boolean isEmailValid() {
        if (mEditTextEmail != null) {
            String email = mEditTextEmail.getText().toString().trim();
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    private boolean isPhoneValid() {
        if (mEditTextPhone != null) {
            String phone = mEditTextPhone.getText().toString().trim();
            if (Patterns.PHONE.matcher(phone).matches()) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    private boolean isAccepted() {
        if (mCheckedBox != null) {
            if (mCheckedBox.isChecked()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public void submitDataOnClick(View view) {
        if (isEmailValid() && isPhoneValid()) {
            if (isAccepted()) {
                mEditTextPhone.setText("");
                mEditTextEmail.setText("");
                mCheckedBox.setChecked(false);
            }
        } else if (!isEmailValid() && isPhoneValid()) {
            mEditTextEmail.setError("Fill the input with a valid email address. Try again!");
        } else if (isEmailValid() && !isPhoneValid()) {
            mEditTextPhone.setError("Fill the input with a valid phone number. Try again!");
        } else {
            mEditTextEmail.setError("");
            mEditTextPhone.setError("");
        }

    }
}