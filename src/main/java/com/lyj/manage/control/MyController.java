package com.lyj.manage.control;


import com.alibaba.fastjson.JSON;
import com.lyj.manage.service.UserService;
import com.lyj.manage.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class MyController {
    @Autowired
    UserServiceImp userService;

    @RequestMapping("/home")
    @ResponseBody
    public String selectAll(){
        return JSON.toJSONString(userService.getUserList());
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
