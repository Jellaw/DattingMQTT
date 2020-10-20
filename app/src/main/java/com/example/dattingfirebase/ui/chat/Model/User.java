package com.example.dattingfirebase.ui.chat.Model;

public class User {
    int imgUser;
    String nameUser;

    public User(int imgUser, String nameUser) {
        this.imgUser = imgUser;
        this.nameUser = nameUser;
    }

    public int getImgUser() {
        return imgUser;
    }

    public void setImgUser(int imgUser) {
        this.imgUser = imgUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
}
