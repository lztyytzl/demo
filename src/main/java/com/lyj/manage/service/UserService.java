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
    //搜索用户
    public User findUser(String uName,String password);
    //查询用户名
    public String searchName(String uName);
    //添加用户
    public boolean addUser(User uzer);
    //删除用户
    public int deleteUser(int id);

}
