package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.model.UserInfoRequest;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/create")
    public String saveUserInfo(@RequestBody UserInfoRequest userInfo) {
        return userInfoService.saveUserInfo(userInfo);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody UserInfoRequest userInfo) {
        return jwtService.generateToken(userInfo.getUsername());
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
