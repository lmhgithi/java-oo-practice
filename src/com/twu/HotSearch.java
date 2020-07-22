package com.twu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotSearch implements Comparable<HotSearch>{
    static List<HotSearch> hotSearchList = new ArrayList<>();
    static List<Integer> hotSearchRankingBuyPriceList = new ArrayList<>();

    String hotSearchName;
    int hotSearchVotes;
    boolean isSupperHot;
    int buyPrice;
    int buyRankNo;

    HotSearch(String name){
        this.hotSearchName = name;
        this.hotSearchVotes = 0;
        this.isSupperHot = false;
        this.buyPrice = 0;
        this.buyRankNo = Integer.MAX_VALUE;
    }

    // 查看热搜列表
    public static void displayHotSearchRankingList(){
        if(hotSearchList.isEmpty()){
            System.out.println("暂时没有热搜...");
            System.out.println("");
            return;
        }
        int ranking = 1;
        int preBuyNo = 0; // 用于隐藏被高价购买而替换的热搜
        for(HotSearch hs : hotSearchList){
            if(hs.buyRankNo != preBuyNo || hs.buyRankNo == Integer.MAX_VALUE) {
                System.out.println(ranking + " " + hs.hotSearchName + " " + hs.hotSearchVotes);
                ranking++;
                preBuyNo = hs.buyRankNo;
            }
        }
        System.out.println("");
    }

    // 添加热搜
    public static boolean addHotSearch(String name){
        if(hotSearchList != null) {
            for (HotSearch hs : hotSearchList) {
                if (hs.hotSearchName.equals(name)) {
                    return false;
                }
            }
        }
        HotSearch tmp = new HotSearch(name);
        hotSearchList.add(tmp);
        hotSearchRankingBuyPriceList.add(0);
        return true;
    }

    // 添加超级热搜
    public static boolean addToSupperHot(String name){
        for (HotSearch hs : hotSearchList) {
            if (name.equals(hs.hotSearchName)) {
                hs.isSupperHot = true;
                return true;
            }
        }

        return false;
    }

    // 给热搜投票
    public static boolean hotSearchAddVotes(String name, int voteNum){
        for(HotSearch hs : hotSearchList){
            if(name.equals(hs.hotSearchName)){
                if(hs.isSupperHot) voteNum *= 2;
                hs.hotSearchVotes += voteNum;
                Ranking();
                return true;
            }
        }
        return false;
    }

    // 购买热搜
    public static boolean hotSearchBuyRank(String name, int price, int no){
        if(hotSearchRankingBuyPriceList.get(no) > price){
            return false;
        }
        hotSearchRankingBuyPriceList.set(no, price);
        for(HotSearch hs : hotSearchList){
            if(name.equals(hs.hotSearchName)){
                hs.buyPrice = price;
                hs.buyRankNo = no;
                Ranking();
                return true;
            }
        }
        return false;
    }

    // 给热搜排序
    private static void Ranking(){
        Collections.sort(hotSearchList);
    }

    @Override
    public int compareTo(HotSearch h1){
        // 有买热搜
        if(this.buyRankNo < h1.buyRankNo) return -1;
        else if(this.buyRankNo > h1.buyRankNo) return 1;
        //买了相同位置的热搜
        else if(this.buyPrice != 0 || h1.buyPrice != 0) {
            if (this.buyPrice > h1.buyPrice) return -1;
            else return 1;
        }
        // 没有买热搜
        else {
            if (this.hotSearchVotes > h1.hotSearchVotes) return -1;
            else return 1;
        }
    }
}
