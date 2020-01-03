package com.gst.boot.shiro.service.impl;

import com.gst.boot.shiro.entity.User;
import com.gst.boot.shiro.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String username) {
        User user = new User();
        user.setUsername("username");
        return user;
    }
}
