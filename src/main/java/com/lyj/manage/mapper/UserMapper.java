package com.lyj.manage.mapper;

import com.lyj.manage.entity.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserMapper {
    public User getUserInfo(int id);

    boolean addUser(User user);
}
