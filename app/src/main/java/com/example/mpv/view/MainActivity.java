package com.example.mpv.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mpv.R;
import com.example.mpv.presenter.login_presenter_new;

public class MainActivity extends AppCompatActivity implements login_view {

    //deklarasi variabel
     EditText edit_username,edit_password;
     Button btn_login;

    private EditText editNama;
    private EditText editPassword;
    private Button btnLogin;

   login_presenter_new login_presenter_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //baca variabel
        edit_username = findViewById(R.id.edit_username);


        initView();
        login_presenter_new= new login_presenter_new(this,MainActivity.this);
        //Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_presenter_new.login(editNama.getText().toString().trim(),editPassword.getText().toString().trim());
            }
        });

    }

    @Override
    public void showValidationError() {
        Toast.makeText(this, "Please enter valid username and password!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "You are successfully logged in!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Invalid login credentials!", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        editNama = findViewById(R.id.edit_nama);
        editPassword = findViewById(R.id.edit_password);
        btnLogin = findViewById(R.id.btn_login);
    }
}