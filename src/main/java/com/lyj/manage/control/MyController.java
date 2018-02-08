package com.lyj.manage.control;


import com.lyj.manage.dao.UserDao;
import com.lyj.manage.entity.User;
import com.lyj.manage.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyController {
    @Resource
    UserDao userDao;

    @RequestMapping("/register")
    @ResponseBody
    public String register(String uid,String userName,String passWord){
        User user=new User();
        user.setUid(uid);
        user.setUsername(userName);
        user.setPassword(passWord);
        int isOk=userDao.insert(user);
        if (isOk>0){
            return "注册成功";
        }else{
            return "注册失败";
        }
    }
}
