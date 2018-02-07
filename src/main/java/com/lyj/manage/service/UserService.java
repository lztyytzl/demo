package com.lyj.manage.service;

import com.lyj.manage.entity.User;

public interface UserService {
    public User getUserInfo(int id);

    boolean addUser(User user);
}
