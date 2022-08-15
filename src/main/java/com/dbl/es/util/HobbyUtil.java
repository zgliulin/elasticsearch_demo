package com.dbl.es.util;

import java.util.*;

/**
 * descrription:
 * <p>
 * Create by DbL on 2022/8/13 9:56
 */
public class HobbyUtil {
    private static List<String> hobbyList = Arrays.asList(
            "兵乓球","滑板","滑旱冰","跳绳","举重","绘画",
            "写小说","看书","积木","拼图","拆装","弹吉他","钢琴","萨克斯","葫芦丝","大号","小号","英雄联盟",
            "QQ堂","CS","CF","地下城勇士","王者荣耀","唱歌","听音乐","看电影","看韩剧","看综艺娱乐节目",
            "看小说","看杂志","逛街","购物","了解市场的行情","跳舞","演奏乐器","去健身房健身",
            "减肥","塑形","瑜伽","足球","篮球","排球","跑步","羽毛球","乒乓球","保龄球","游泳","划船",
            "水上娱乐","登山","郊游","钓鱼","养鱼","饲养宠物","玩网络游戏","","单机游戏","上网聊天","论坛","贴吧",
            "看新闻","摄影","摄像","旅游","自驾游","吃美食","做饭","做糕点","十字绣","织毛衣","做服装服饰",
            "打扑克","麻将","睡觉","写字","练字","书法","下各种棋","美容","保养","化妆","打扮");

    public static List<String> randomHobbys(){
        int count = NumberUtil.randomInt(2, 6);
        Map<Integer,Integer> indexMap = new HashMap<>(count);
        Random random = new Random();

        while(count > 0) {
            int index = random.nextInt(hobbyList.size() - 1);
            if (indexMap.containsKey(index)) {
                continue;
            }else {
                indexMap.put(index,index);
                count--;
            }
        }
        List<String> result = new ArrayList<>();
        for (Integer idx : indexMap.keySet()) {
            result.add(hobbyList.get(idx));
        }
        return result;
    }
}
