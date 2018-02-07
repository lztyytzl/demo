package com.lyj.manage.control;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/sayHello")
    public String sayHello(){
        return "你好";
    }
}
