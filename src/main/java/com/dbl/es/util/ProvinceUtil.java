package com.dbl.es.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * descrription:
 * <p>
 * Create by DbL on 2022/8/13 9:31
 */
public class ProvinceUtil {
    private static List<String> provinceList = Arrays.asList(
            "北京市","上海市","天津市","重庆市","黑龙江省","吉林省","辽宁省","内蒙古","河北省","新疆"
            ,"甘肃省","青海省","陕西省","宁夏","河南省","山东省","山西省","安徽省","湖北省","湖南省"
            ,"江苏省","四川省","贵州省","云南省","广西省","西藏","浙江省","江西省","广东省","福建省"
            ,"台湾省","海南省","香港","澳门");

    public static String randomProvince() {
        Random random = new Random();
        int index = random.nextInt(provinceList.size() - 1);
        return provinceList.get(index);
    }
}
