package com.lyj.manage.dao;

import com.lyj.manage.entity.Auth;

import java.util.List;

public interface AuthDao {
    List<Auth> selectAuth(Integer pid);
}
