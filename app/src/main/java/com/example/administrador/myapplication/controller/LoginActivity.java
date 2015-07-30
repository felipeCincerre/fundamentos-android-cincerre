package com.example.administrador.myapplication.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.myapplication.R;
import com.example.administrador.myapplication.model.entities.Client;
import com.example.administrador.myapplication.model.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 20/07/2015.
 */
public class LoginActivity extends AppCompatActivity {
    public static String USER_PARAM = "USER_PARAM";
    private EditText editTextLogin;
    private EditText editTextPassword;
    private List<User> userList = new ArrayList<>();
    Button buttonLogin;
    private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        saveAdmin();
        bindFields();

    }

    private void bindFields() {
        editTextLogin = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        bindLoginButton();
    }

    private void saveAdmin() {
        userList = user.getAll();
        if(userList.isEmpty()) {
            user.save();
        }
        userList.clear();
    }

    private void bindLoginButton() {
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindUser();
                userList = user.authentication();
                if (!userList.isEmpty()) {
                    Intent goToMainActivity = new Intent(LoginActivity.this, ClientListActivity.class);
                    startActivity(goToMainActivity);
                } else {
                    Toast.makeText(LoginActivity.this, LoginActivity.this.getString(R.string.invalid), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void bindUser() {
        if (user == null) {
            user = new User();
        }
        user.setLogin(editTextLogin.getText().toString());
        user.setPassword(editTextPassword.getText().toString());
    }
}
