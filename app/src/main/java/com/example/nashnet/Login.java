package com.example.nashnet;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.nashnet.MainActivity.errormes;
import static com.example.nashnet.MainActivity.status;
import static com.example.nashnet.MainActivity.pas;
import static com.example.nashnet.MainActivity.log;


public class Login extends Activity {
    EditText editTextlogin, editTextpass;
    CheckBox checkBox;
    final String USERNAME = "Сохраненное имя";
    final String PASSWORD = "Сохраненный пароль";
    SharedPreferences mSharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        TextView texterror = findViewById(R.id.errormes);
        editTextpass = (EditText) findViewById(R.id.editTextTextPassword);
        editTextlogin = (EditText) findViewById(R.id.editTextLogin);
        mSharedPref = getPreferences(MODE_PRIVATE);
        String saved_name = mSharedPref.getString(USERNAME, "");
        String saved_pass = mSharedPref.getString(PASSWORD, "");
        editTextlogin.setText(saved_name);
        editTextpass.setText(saved_pass);


        if (errormes == null) {
            status = "Введіть логін та пароль";
            texterror.append(status);
        } else {
            status = "Невірний логін або пароль";
            texterror.append(status);
        }


    }


    public void Connect(View view) {
        editTextpass = (EditText) findViewById(R.id.editTextTextPassword);
        editTextlogin = (EditText) findViewById(R.id.editTextLogin);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        String text = editTextlogin.getText().toString();
        log = text;
        String text2 = editTextpass.getText().toString();
        pas = text2;
        if (text.equals("") || text2.equals("")) {
            Toast.makeText(this, "Введите логин и пароль", Toast.LENGTH_SHORT).show();
        } else {
            if (checkBox.isChecked() == true) {

                mSharedPref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor mEditor = mSharedPref.edit();
                mEditor.putString(USERNAME, editTextlogin.getText().toString());
                mEditor.putString(PASSWORD, editTextpass.getText().toString());
                mEditor.commit();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();

            } else if (checkBox.isChecked() == false) {

                mSharedPref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor mEditor = mSharedPref.edit();
                mEditor.putString(USERNAME, "");
                mEditor.putString(PASSWORD, "");
                mEditor.commit();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();


            }

        }


    }


}










