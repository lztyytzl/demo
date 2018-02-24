package com.lyj.manage.control;


import com.alibaba.fastjson.JSON;
import com.lyj.manage.entity.Code;
import com.lyj.manage.entity.User;
import com.lyj.manage.service.UserService;
import com.lyj.manage.service.UserServiceImp;
import com.lyj.manage.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImp userService;

    @RequestMapping( value = "/home",method = RequestMethod.GET)
    @ResponseBody
    public String selectAll(){
        return JSON.toJSONString(userService.getUserList());
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String findUser(String name,String password){
       if (name!=null && !name.equals("") && password!=null && !password.equals("")){
           User user=userService.findUser(name,password);
           try{
               if (user!=null){
                   return JSON.toJSONString(user);
               }else{
                   return JSON.toJSONString(new Code(200,"用户名密码错误!"));
               }
           }catch (Exception e){
               return JSON.toJSONString(new Code(100,"服务器错误!"));
           }
       }else{
            return JSON.toJSONString(new Code(203,"用户名密码不能为空!"));
       }
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @ResponseBody
    public String register(String userName,String password){
        if (userName!=null && !userName.equals("") && password!=null && !password.equals("")){
            try{
                User uzer=new User();
                uzer.setName(userName);
                uzer.setPassword(MD5Util.Md5EncodeToPwd(password));
                boolean resFlag=userService.addUser(uzer);
                if (resFlag==true){
                    return JSON.toJSONString(new Code(200,"注册成功!"));
                }else{
                    return JSON.toJSONString(new Code(202,"注册失败!"));
                }
            }catch (Exception e){
                return JSON.toJSONString(new Code(100,"服务器错误!"));
            }
        }else{
            return JSON.toJSONString(new Code(203,"用户名密码不能为空!"));
        }
    }


//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @RequestMapping("/getUser")
//    public List<Map<String,Object>> getUser(){
//        String sql="select * from initname";
//        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
//        for (Map<String,Object> map: list){
//            Set<Map.Entry<String,Object>> entries=map.entrySet();
//            if (entries!=null){
//                Iterator<Map.Entry<String,Object>> iterator=entries.iterator();
//                while (iterator.hasNext()){
//                    Map.Entry<String,Object> entry=iterator.next();
//                    Object key=entry.getKey();
//                    Object value=entry.getValue();
//                }
//            }
//        }
//        return list;
//    }

}
