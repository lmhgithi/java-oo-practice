package com.twu;

import java.util.Scanner;
import com.twu.*;

public class Main {
    public static void main(String[] args) {
        String hotSearchName = "";
        while(true) {
            boolean mainExitFlag = false;
            String person = MenuDisplay.menuLogin();
            switch (person) {
                case "1"://管理员
                    String adminName = MenuDisplay.input("用户名");
                    String adminPassword = MenuDisplay.input("密码");
                    boolean loginFlag = Admin.login(adminName, adminPassword);
                    MenuDisplay.successOrFail("登录", loginFlag);
                    if(!loginFlag){
                        mainExitFlag = true;
                        break;
                    }
                    boolean adminExitFlag = false;
                    while (true) {
                        String adminOp = MenuDisplay.adminDisplay(Admin.adminName);
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
                        if (adminExitFlag) {
                            break;
                        }
                    }
                    break;
                case "2"://普通用户
                    boolean userExitFlag = false;
                    String userName = MenuDisplay.input("用户名");
                    User user = new User(userName);
                    while (true) {
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
                        if (userExitFlag) {
                            break;
                        }
                    }
                    break;
                case "0": //退出
                    mainExitFlag = true;
                    MenuDisplay.menuExit();
            }
            if (mainExitFlag) {
                break;
            }
        }
    }
}
