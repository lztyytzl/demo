package com.lyj.manage.service;

import com.lyj.manage.dao.UserDao;
import com.lyj.manage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp  implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.findAll();
    }

}
