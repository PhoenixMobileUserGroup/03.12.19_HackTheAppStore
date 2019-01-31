package com.chrismyers.unsecurestringandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String SECURE_STRING = "JcVm98d*=R+ffY9CQ&arr7T92ZoNH27ccQUZJ^,*9Jn7A(}UT.qMf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void validate(View view) {
        EditText input = findViewById(R.id.editValidation);
        String inputValue = input.getText().toString();
        Boolean isValid = inputValue.contentEquals(SECURE_STRING);

        String resultMessage = isValid ? "Valid!" : "Invalid!";
        TextView result = findViewById(R.id.textResult);
        result.setText(resultMessage);
    }
}
