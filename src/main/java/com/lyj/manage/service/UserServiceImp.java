package com.lyj.manage.service;

import com.lyj.manage.dao.UserDao;
import com.lyj.manage.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImp implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public User getUserInfo(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean addUser(User user) {
        boolean flag=false;
        try{
            userDao.insert(user);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
