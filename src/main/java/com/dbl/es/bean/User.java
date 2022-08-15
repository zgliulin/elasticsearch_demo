package com.dbl.es.bean;

import com.alibaba.fastjson.JSON;
import com.dbl.es.util.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * descrription:
 * <p>
 * Create by DbL on 2022/8/8 21:40
 */
@Data
public class User {
    private String name;
    private Integer age;
    private String nativePlace;
    private String phone;
    private String school;
    // 0 ：男 1 ：女
    private Integer sex;
    private Double height;
    private Double weight;
    private List<String> hobbys;
    private LocalDate birthday;

    public static List<User> getRandomUser(int size) {
        List<User> userList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            User user = new User();
            user.setName(NameUtil.getChineseName());
            user.setAge(NumberUtil.randomInt(18,75));
            user.setBirthday(LocalDate.now().plusYears(0-user.getAge()).plusDays(0-NumberUtil.randomInt(0,364)));
            user.setHeight(NumberUtil.randomDouble(150, 240, 1));
            user.setWeight(NumberUtil.randomDouble(45, 120, 2));
            user.setNativePlace(ProvinceUtil.randomProvince());
            user.setSchool(SchoolUtil.randomSchool());
            user.setPhone(PhoneUtil.createMobile());
            user.setHobbys(HobbyUtil.randomHobbys());
            user.setSex(NumberUtil.randomInt(0,2));
            userList.add(user);
        }
        return userList;
    }
    public  String userToJson() {
        return JSON.toJSONString(this);
    }
}
