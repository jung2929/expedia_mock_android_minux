package com.example.expedia03.entities;

public class SignUpData {
    private String Email, Name;
    private String Pw;
    private String token;

    public SignUpData(){

    }

    public SignUpData(String email, String pw) {
        Email = email;
        Pw = pw;
    }

    public SignUpData(String email, String pw, String name) {
        Email = email;
        Pw = pw;
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPw() {
        return Pw;
    }

    public String getName() {
        return Name;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
