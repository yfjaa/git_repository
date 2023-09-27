package com.baidu.service;

import com.baidu.mapper.UserMapper;
import com.baidu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User Login(User user) {
        return userMapper.Login(user);
    }
}
