package com.dbl.es.service;

import com.dbl.es.bean.User;

import java.util.List;

/**
 * descrription:
 * <p>
 * Create by DbL on 2022/8/8 23:12
 */
public class Test {
    public static void main(String[] args) {
        List<User> randomUser = User.getRandomUser(10);
        for (User user : randomUser) {
            System.out.println(user.userToJson());
        }

    }
}
