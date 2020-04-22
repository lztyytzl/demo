package com.lyj.manage.service;

import com.lyj.manage.dao.AuthDao;
import com.lyj.manage.entity.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthSerImp implements AuthService {
    @Autowired
    private AuthDao authDao;

    @Override
    public List<Auth> selectAuth(Integer pid) {
        try{
            return authDao.selectAuth(pid);
        }catch (Exception e){
            return null;
        }
    }
}
