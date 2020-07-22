package com.twu;

import java.util.List;
// 只暂时管理一次登录累计投票数，不进行储存
public class User {
    String userName;
    int userVotes = 10;
    User(String name){
        this.userName = name;
    }
    // 用户投票
    public boolean userVoteToHotSearch(String name, int voteNum){
        if(voteNum > this.userVotes){
            return false;
        }else{
            this.userVotes -= voteNum;
            return HotSearch.hotSearchAddVotes(name, voteNum);
        }
    }

    // 用户购买热搜
    public boolean userBuyHotSearch(String name, Double price, int no){
        // 需求里没有说有余额的说法，但是为了结构合理还是在User中调用购买热搜
        return HotSearch.hotSearchBuyRank(name, price, no);
    }
}