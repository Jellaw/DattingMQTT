package com.example.dattingfirebase.ui.profile.Model;

public class PreProfile {
    int img_profile;
    String name;
    String age;

    public PreProfile(int img_profile, String name, String age) {
        this.img_profile = img_profile;
        this.name = name;
        this.age = age;
    }

    public int getImg_profile() {
        return img_profile;
    }

    public void setImg_profile(int img_profile) {
        this.img_profile = img_profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
