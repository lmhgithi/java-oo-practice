package com.twu;

public class Admin {
    String adminName;
    String adminPassword;

    Admin(String name, String password){
        this.adminName = name;
        this.adminPassword = password;
    }
    // 管理员登录
    public boolean login(String name, String password){
        return name.equals(this.adminName) && password.equals(this.adminPassword);
    }
}
