package com.example.homework004.bean;

public class UserInfo {
    public long rowid;
    public int sn;
    public String name;
    public int age;
    public boolean gender;
    public boolean district;
    public String update_time;
    public String phone;
    public String pwd;

    public UserInfo() {
        rowid = 0L;
        sn = 0;
        name = "";
        age = 0;
        gender = false;
        district = false;
        update_time = "";
        phone = "";
        pwd = "";
    }
}
