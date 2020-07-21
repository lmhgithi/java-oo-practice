package com.twu;

import java.util.Scanner;
import com.twu.MenuDisplay;
public class Main {
    public static void main(String[] args) {
        while(true) {
            boolean mainExitFlag = false;
            System.out.println("欢迎来到热搜排行榜，你是？");
            System.out.println("1.管理员");
            System.out.println("2.用户");
            System.out.println("0.退出");
            Scanner sc = new Scanner(System.in);
            String user = sc.nextLine();
            switch (user) {
                case "1"://管理员
                    boolean adminExitFlag = false;
                    while (true) {
                        MenuDisplay.adminDisplay();
                        String adminOp = sc.nextLine();
                        switch (adminOp) {
                            case "1":
                                System.out.println("ok");
                                break;
                            case "2":
                                System.out.println("ok");
                                break;
                            case "3":
                                System.out.println("ok");
                                break;
                            case "0":
                                adminExitFlag = true;
                                System.out.println("对话结束...");
                                break;
                        }
                        if (adminExitFlag) {
                            break;
                        }
                    }
                    break;
                case "2"://普通用户
                    boolean userExitFlag = false;
                    while (true) {
                        System.out.println("1.查看热搜排行榜");
                        System.out.println("2.给热搜时间投票");
                        System.out.println("3.购买热搜");
                        System.out.println("4.添加热搜");
                        System.out.println("0.退出");
                        String adminOp = sc.nextLine();
                        switch (adminOp) {
                            case "1":
                                System.out.println("ok");
                                break;
                            case "2":
                                System.out.println("ok");
                                break;
                            case "3":
                                System.out.println("ok");
                                break;
                            case "4":
                                System.out.println("ok");
                                break;
                            case "0":
                                userExitFlag = true;
                                System.out.println("对话结束...");
                                break;
                        }
                        if (userExitFlag) {
                            break;
                        }
                    }
                    break;
                case "0":
                    mainExitFlag = true;
                    System.out.println("对话结束...");
            }
            if (mainExitFlag) {
                break;
            }
        }
    }
}
