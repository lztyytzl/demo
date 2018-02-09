package com.lyj.manage.service;

import com.lyj.manage.entity.User;

import java.util.List;

public interface UserService {
    public User getUserInfo(int id);

    boolean addUser(User user);

    public List<User> selectAll();
}
