package com.example.mpv.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.mpv.model.model_login;
import com.example.mpv.view.login_view;


public class login_presenter_new {

    private Context ctx;
    private login_view loginView;
     model_login model_login;
    public login_presenter_new(login_view view, Context ctx) {
        this.ctx = ctx;
        this.loginView = view;

    }

    public void login(String username,String password ){
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
           model_login.setStatus("0");
        } else {
            if (username.equals("admin") && password.equals("admin")) {
                loginView.loginSuccess();
            } else {
                loginView.loginError();
            }
        }




    }


}






