package com.dbl.es.controller;

import com.dbl.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * descrription:
 * <p>
 * Create by DbL on 2022/8/13 10:30
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/init")
    public void initEsUserInfo(Integer size) {
        userService.initEsUserInfo(size);
    }

    @GetMapping("/test")
    public String test() {
        return "success";
    }
}
