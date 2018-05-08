package com.example.mgluc.androidshoppracadyplomowa.Model;

/**
 * Created by mgluc on 06.05.2018.
 */

public class Users2 {
    //klasa pod Model tabeli jsonowej, firebase

    private String Name;
    private String Password;
    private String Gender;

    public Users2(String name, String password, String gender) {
        Name = name;
        Password = password;
        Gender = gender;
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

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
