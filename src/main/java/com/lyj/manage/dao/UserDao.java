package com.lyj.manage.dao;

import com.lyj.manage.entity.User;

/**
 * create by lyj
 * 数据库操作层
 */
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
