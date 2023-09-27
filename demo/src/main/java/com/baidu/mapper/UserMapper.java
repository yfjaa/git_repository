package com.baidu.mapper;

import com.baidu.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
    User Login(User user);
}
