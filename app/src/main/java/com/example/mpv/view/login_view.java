package com.example.mpv.view;

public interface login_view {
    /**
     * Menampilkan toast validation error.
     */
    void showValidationError();
    /**
     * Login success.
     */
    void loginSuccess();
    /**
     * Menampilkan toast login error.
     */
    void loginError();
}
