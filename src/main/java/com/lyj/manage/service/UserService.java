package com.lyj.manage.service;

import com.lyj.manage.dao.UserDao;
import com.lyj.manage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //遍历
    public List<User> getUserList();
    //搜索
    public User findUser(String uName,String password);
    //添加用户
    public boolean addUser(User uzer);

}
