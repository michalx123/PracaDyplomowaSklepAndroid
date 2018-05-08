package com.example.mgluc.androidshoppracadyplomowa.Model;

/**
 * Created by mgluc on 06.05.2018.
 */

public class Users {
    //klasa pod Model tabeli jsonowej, firebase

    private String Name;
    private String Password;

    public Users() {
    }

    public Users(String name, String password) {
        Name = name;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
