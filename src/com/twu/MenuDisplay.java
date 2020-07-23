package com.twu;

import java.util.Scanner;

public class MenuDisplay {
    static Scanner sc = new Scanner(System.in);
    public static void theMenu(){
        String hotSearchName;
        boolean mainExitFlag = false;
        while(!mainExitFlag) {
            String person = MenuDisplay.menuLogin();
            switch (person) {
                case "1"://管理员
                    boolean adminExitFlag = false;
                    Admin admin = new Admin("admin", "admin123");
                    String adminName = MenuDisplay.input("用户名");
                    String adminPassword = MenuDisplay.input("密码");
                    boolean loginFlag = admin.login(adminName, adminPassword);
                    MenuDisplay.successOrFail("登录", loginFlag);
                    if(!loginFlag){
                        adminExitFlag = true;
                    }

                    while (!adminExitFlag) {
                        String adminOp = MenuDisplay.adminDisplay(admin.adminName);
                        switch (adminOp) {
                            case "1": //查看热搜排行榜
                                HotSearch.displayHotSearchRankingList();
                                break;
                            case "2": //添加热搜
                                hotSearchName = MenuDisplay.input("热搜名");
                                MenuDisplay.successOrFail("添加热搜", HotSearch.addHotSearch(hotSearchName));
                                break;
                            case "3": //添加超级热搜
                                String supperHotSearchName = MenuDisplay.input("要升为超级热搜的名字");
                                MenuDisplay.successOrFail("添加超级热搜", HotSearch.addToSupperHot(supperHotSearchName));
                                break;
                            case "0": //退出
                                adminExitFlag = true;
                                MenuDisplay.menuExit();
                                break;
                        }
                    }
                    break;
                case "2"://普通用户
                    boolean userExitFlag = false;
                    String userName = MenuDisplay.input("用户名");
                    User user = new User(userName);
                    while (!userExitFlag) {
                        String adminOp = MenuDisplay.userDisplay(user.userName);
                        switch (adminOp) {
                            case "1": //查看热搜排行榜
                                HotSearch.displayHotSearchRankingList();
                                break;
                            case "2": //给热搜事件投票
                                hotSearchName = MenuDisplay.input("热搜名");
                                int voteNum = Integer.parseInt(MenuDisplay.input("投票数"));
                                MenuDisplay.successOrFail("投票", user.userVoteToHotSearch(hotSearchName, voteNum));
                                break;
                            case "3": //购买热搜
                                hotSearchName = MenuDisplay.input("热搜名");
                                int buyNo = Integer.parseInt(MenuDisplay.input("位置"));
                                Double buyPrice = Double.parseDouble(MenuDisplay.input("购买金额"));
                                MenuDisplay.successOrFail("购买", user.userBuyHotSearch(hotSearchName, buyPrice, buyNo));
                                break;
                            case "4": //添加热搜
                                hotSearchName = MenuDisplay.input("热搜名");
                                MenuDisplay.successOrFail("添加热搜", HotSearch.addHotSearch(hotSearchName));
                                break;
                            case "0": //退出
                                userExitFlag = true;
                                MenuDisplay.menuExit();
                                break;
                        }
                    }
                    break;
                case "0": //退出
                    mainExitFlag = true;
                    MenuDisplay.menuExit();
            }
        }
    }
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
        System.out.println();
    }

    public static void menuExit(){
        System.out.println("对话结束...");
        System.out.println();
    }

}
