package com.example.dattingfirebase.ui.home.Model;

public class UserCompass {
    int img, imgChamxanh;
    String name;

    public UserCompass(int img, int imgChamxanh, String name) {
        this.img = img;
        this.imgChamxanh = imgChamxanh;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgChamxanh() {
        return imgChamxanh;
    }

    public void setImgChamxanh(int imgChamxanh) {
        this.imgChamxanh = imgChamxanh;
    }
}
