package com.example.map524_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    Button loginBtn;
    EditText emailAddress;
    EditText password;
    TextView errorMsg;
    EditText username;
    CheckBox rememberME;
    //SharedPreferences pref;
    private static final String FILE_NAME = "myFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = findViewById(R.id.button2);
        emailAddress = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        errorMsg = findViewById(R.id.textView5);
        username = findViewById(R.id.userNameText);

        //shared preference
        rememberME = findViewById(R.id.rememberCheck);
        loadUserCredentials();
        if(emailAddress.getText().toString().equals("admin@example.com") && password.getText().toString().equals("1234")) {
            Intent loginIntent = new Intent(getApplicationContext(), StorePageActivity.class);
            String tempUserName = username.getText().toString();
            loginIntent.putExtra("name", tempUserName);
            startActivity(loginIntent);
        }else {
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (emailAddress.getText().toString().equals("admin@example.com") && password.getText().toString().equals("1234")) {
                        Intent loginIntent = new Intent(getApplicationContext(), StorePageActivity.class);
                        String tempUserName = username.getText().toString();
                        loginIntent.putExtra("name", tempUserName);
                        errorMsg.setText("");
                        startActivity(loginIntent);
                        if (rememberME.isChecked()) {
                            saveUserCredentials(emailAddress.getText().toString(), password.getText().toString(), username.getText().toString(), rememberME.isChecked());
                        } else if (!rememberME.isChecked()) {
                            clear(emailAddress.getText().toString(), password.getText().toString(), username.getText().toString(), rememberME.isChecked());
                        }
                    } else {
                        errorMsg.setText("Invalid email or password, please try again");
                        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                    }
                }
            });
        }
    }

    void saveUserCredentials(String userEmail, String userPassword, String userName, boolean state){
        //pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME, MODE_PRIVATE).edit();
        //SharedPreferences.Editor editor = pref.edit();
        editor.putString("emailKey", userEmail);
        editor.putString("passwordKey", userPassword);
        editor.putBoolean("stateKey", state);
        editor.putString("userNameKey", userName);
        editor.apply();
    }

    void clear(String userEmail, String userPassword, String userName, boolean state){
        SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME, MODE_PRIVATE).edit();
        //SharedPreferences.Editor editor = pref.edit();
        editor.putString("emailKey", "");
        editor.putString("passwordKey", "");
        editor.putBoolean("stateKey", false);
        editor.putString("userNameKey", "");
        editor.apply();
    }


    void loadUserCredentials(){
        SharedPreferences pref = getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        //pref = PreferenceManager.getDefaultSharedPreferences(this);
        //Load the data by using keys, if the key is null set the value of the key to empty
        String savedEmail = pref.getString("emailKey", "");
        emailAddress.setText(savedEmail);

        String savedPassword = pref.getString("passwordKey", "");
        password.setText(savedPassword);

        String savedUserName = pref.getString("userNameKey", "");
        username.setText(savedUserName);

        boolean savedStatus = pref.getBoolean("stateKey", false);
        rememberME.setChecked(savedStatus);
    }

}