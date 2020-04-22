package com.lyj.manage.service;

import com.lyj.manage.entity.Auth;

import java.util.List;

public interface AuthService {
    public List<Auth> selectAuth(Integer pid);
}
