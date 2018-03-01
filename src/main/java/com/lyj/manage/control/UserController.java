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

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImp userService;

    @RequestMapping( value = "/home",method = RequestMethod.GET)
    @ResponseBody
    public String selectAll(){
        try{
            List<User> userList=userService.getUserList();
            if (userList.size()>0) {
                return JSON.toJSONString(new Code(200,userService.getUserList()));
            }else{
                return JSON.toJSONString(new Code(200,"[]"));
            }
        }catch (Exception e){
            return JSON.toJSONString(new Code(403,"服务器错误"));
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String findUser(String name,String password){
       if (name!=null && !name.equals("") && password!=null && !password.equals("")){
           User user=userService.findUser(name,MD5Util.Md5EncodeToPwd(password));
           try{
               if (user!=null){
                   Code code=new Code(200,user);
                   return JSON.toJSONString(code);
               }else{
                   return JSON.toJSONString(new Code(202,"用户名或密码错误!"));
               }
           }catch (Exception e){
               return JSON.toJSONString(new Code(403,"服务器错误!"));
           }
       }else{
            return JSON.toJSONString(new Code(203,"用户名密码不能为空!"));
       }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(String userName,String password){
        if (userName!=null && !userName.trim().equals("") && password!=null && !password.trim().equals("")){
            try{
                if (userService.searchName(userName)!=null){
                    return JSON.toJSONString(new Code(201,"该账号已被注册"));
                }else{
                    User uzer=new User();
                    uzer.setName(userName);
                    uzer.setPassword(MD5Util.Md5EncodeToPwd(password));
                    boolean resFlag=userService.addUser(uzer);
                    if (resFlag==true){
                        return JSON.toJSONString(new Code(200,"注册成功!"));
                    }else{
                        return JSON.toJSONString(new Code(202,"注册失败!"));
                    }
                }
            }catch (Exception e){
                return JSON.toJSONString(new Code(403,"服务器错误!"));
            }
        }else{
            return JSON.toJSONString(new Code(203,"用户名密码不能为空!"));
        }
    }

    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
    public String cancelUser(String id){
        if (id!=null && !id.trim().equals("")){
            try{
                int rsCount=userService.deleteUser(Integer.parseInt(id));
                if (rsCount>0){
                    return JSON.toJSONString(new Code(200,"删除成功!"));
                }else{
                    return JSON.toJSONString(new Code(202,"删除失败，请重试!"));
                }
            }catch (Exception e){
                return JSON.toJSONString(new Code(403,"服务器错误!"));
            }
        }else{
            return JSON.toJSONString(new Code(203,"请选择一个用户再进行操作"));
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
