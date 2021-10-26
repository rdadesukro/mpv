package com.example.mpv.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.mpv.model.login_view;


public class login_presenter_new {

    private Context ctx;
    private login_view loginView;
    public login_presenter_new(login_view view, Context ctx) {
        this.ctx = ctx;
        this.loginView = view;

    }

    public void login(String username,String password ){
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            loginView.showValidationError();
        } else {
            if (username.equals("admin") && password.equals("admin")) {
                loginView.loginSuccess();
            } else {
                loginView.loginError();
            }
        }

    }


}






