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
        try{
            return userDao.findAll();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public User findUser(String uName, String password) {
        User uzer =userDao.selectByUser(uName,password);
        try{
            if (uzer!=null){
                return uzer;
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean addUser(User uzer) {
         boolean isOk=false;
         int res=userDao.insert(uzer);
         if (res>0){
             isOk=true;
         }else{
             isOk=false;
         }
        return isOk;
    }
}
