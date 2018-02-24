package com.lyj.manage.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码采用MD5加密
 */
public class MD5Util {
    /**
     * 密码加密
     * @param pwd
     * @return
     */
    public static String Md5EncodeToPwd(String pwd){
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder=new BASE64Encoder();
            String codeStr=base64Encoder.encode(md5.digest(pwd.getBytes("UTF-8")));
            return codeStr;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

    }


}
