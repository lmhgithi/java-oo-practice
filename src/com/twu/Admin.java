package com.twu;

public class Admin {
    // 固定的用户名和密码登录，仅用于校验
    static String adminName = "admin";
    static String adminPassword = "admin123";

    // 管理员登录
    public static boolean login(String name, String password){
        if(name.equals(adminName) && password.equals(adminPassword)){
            return true;
        }
        return false;
    }
}
