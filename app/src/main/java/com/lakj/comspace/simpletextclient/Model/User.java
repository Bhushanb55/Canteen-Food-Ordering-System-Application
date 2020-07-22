package com.lakj.comspace.simpletextclient.Model;

import android.widget.EditText;

public class User {
    private String Name;
    private static String Password;

    public User(String name, EditText edtPassword) {
    }

    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
