package com.twu;

import java.util.Scanner;

public class MenuDisplay {
    static Scanner sc = new Scanner(System.in);
    public static String menuLogin(){
        System.out.println("欢迎来到热搜排行榜，你是？");
        System.out.println("1.管理员");
        System.out.println("2.用户");
        System.out.println("0.退出");
        return sc.nextLine();
    }

    public static String input(String someThing){
        System.out.println("请输入"+ someThing +"：");
        return sc.nextLine();
    }

    public static String adminDisplay(String name){
        System.out.println("你好，" + name + "你可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.添加热搜");
        System.out.println("3.添加超级热搜");
        System.out.println("0.退出");
        return sc.nextLine();
    }

    public static String userDisplay(String name){
        System.out.println("你好，" + name + "你可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.给热搜投票");
        System.out.println("3.购买热搜");
        System.out.println("4.添加热搜");
        System.out.println("0.退出");
        return sc.nextLine();
    }

    public static void successOrFail(String task, boolean fact){
        if(fact) System.out.println(task + "成功...");
        else System.out.println(task + "失败...");
        System.out.println("");
    }

    public static void menuExit(){
        System.out.println("对话结束...");
        System.out.println("");
    }

}
