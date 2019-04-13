package com.example.demo.service;

import com.example.demo.domain.UserInfo;

/**
 * Created by iandtop on 2018/12/11.
 */
public interface UserInfoService {
    UserInfo findByUsername(String username);
}
