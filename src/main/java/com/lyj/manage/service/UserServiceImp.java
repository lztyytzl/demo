package com.lyj.manage.service;

import com.lyj.manage.dao.UserDao;
import com.lyj.manage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User getUserInfo(int id) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public List<User> selectAll() {
        List<User> list=userDao.findAll();
        return list;
    }
}
