package com.example.demo.service;

import com.example.demo.entity.UserInfo;
import com.example.demo.model.UserInfoRequest;
import com.example.demo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUserInfo(UserInfoRequest userInfoRequest) {
        userInfoRepository.save(UserInfo.builder()
                .username(userInfoRequest.getUsername())
                .email(userInfoRequest.getEmail())
                .phone(userInfoRequest.getPhone())
                .password(passwordEncoder.encode(userInfoRequest.getPassword()))
                .role(userInfoRequest.getRole())
                .build());
        return "Added user ";
    }
}
