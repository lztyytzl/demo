package com.lyj.manage.control;

import com.alibaba.fastjson.JSON;
import com.lyj.manage.entity.Auth;
import com.lyj.manage.entity.Code;
import com.lyj.manage.service.AuthSerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthSerImp authSerImp;

    @RequestMapping(value = "/getRole",method = RequestMethod.GET)
    @ResponseBody
    public String getRole(Integer pid){
        try{
            List<Auth> auth=authSerImp.selectAuth(pid);
            Code code=new Code(200,auth);
            return JSON.toJSONString(code);
        }catch (Exception e){
            System.out.print(e);
            return JSON.toJSONString(new Code(403,"服务器错误!"));
        }
    }
}
