package com.example.map524_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Button loginBtn;
    EditText emailAddress;
    EditText password;
    TextView errorMsg;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = findViewById(R.id.button2);
        emailAddress = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        errorMsg = findViewById(R.id.textView5);
        username = findViewById(R.id.userNameText);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailAddress.getText().toString().equals("admin@example.com") && password.getText().toString().equals("1234")) {
                    Intent loginIntent = new Intent(MainActivity.this, StorePageActivity.class);
                    String tempUserName = username.getText().toString();
                    loginIntent.putExtra("name",tempUserName);
                    startActivity(loginIntent);
                    errorMsg.setText("");
                }else{
                    errorMsg.setText("Invalid email or password, please try again");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                }
            }
        });

    }
}