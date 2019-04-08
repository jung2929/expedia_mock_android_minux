package com.example.expedia03.entities;

public class SignUpJson {
    String Email, Pw, Name;

    public SignUpJson(String email, String pw) {
        Email = email;
        Pw = pw;
    }

    public SignUpJson(String email, String pw, String name) {
        Email = email;
        Pw = pw;
        Name = name;
    }

}
