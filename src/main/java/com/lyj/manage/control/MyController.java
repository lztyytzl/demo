package com.lyj.manage.control;


import com.lyj.manage.entity.User;
import com.lyj.manage.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyController {
    @Resource
    UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public String register(String uid,String userName,String passWord){
        User user=new User();
        user.setUid(uid);
        user.setUsername(userName);
        user.setPassword(passWord);
        boolean isOk=this.userService.addUser(user);
        if (isOk==true){
            return "注册成功";
        }else{
            return "注册失败";
        }
    }
}
