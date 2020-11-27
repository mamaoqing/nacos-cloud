package com.mq.cloud;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.DigestUtils;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Calendar;

/**
 * 密码加密工具
 *
 * @author mq
 * @description: 密码工具
 * @title: PasswordEncryption
 * @projectName nacos-cloud
 * @date 2020/11/2716:03
 */
public class PasswordEncryption {

    static final BASE64Encoder ENCODER = new BASE64Encoder();

    private static final String CODE_STR = "mmq";


    /**
     * md5 加密
     *
     * @param password 密码
     * @return 返回密文
     */
    public static String setMd5String(String password, String str) {
        if (StringUtils.isEmpty(str)) {
            str = CODE_STR;
        }
        StringBuilder sbf = new StringBuilder();
        sbf.append(password);
        //在用户输入的密码两头拼接sdzy
        sbf.insert(0, str);
        sbf.insert(password.length() - 1, str);
        //用md5加密
        return DigestUtils.md5DigestAsHex(sbf.toString().getBytes());
    }

    /**
     * 默认拼接字符串方法
     *
     * @param password 需要加密的字符串
     * @return 返回密文
     */
    public static String setMd5String(String password) {
        return setMd5String(password, null);
    }

    /**
     * 处理字符串
     *
     * @param pwd 文字
     * @return 返回
     */
    public static String dealString(String pwd) {
        StringBuilder sb = new StringBuilder(pwd);
        String now = Calendar.getInstance().getTimeInMillis() + "";
        sb.setLength(0);
        sb.append(pwd).append("_").append(now);
        return sb.toString();
    }

    /**
     * 加密
     *
     * @param pwd 需要加密的文字
     * @param str 统一添加的字符
     * @return 返回一个字符串
     */
    public static String encryption(String pwd, String str) {
        if (StringUtils.isEmpty(pwd))
            throw new NullPointerException();
        // 先进行md5加密
        String md5Str = setMd5String(pwd, str);
        // 在进行base64加密
        return ENCODER.encode(md5Str.getBytes());
    }

    /**
     * @param pwd 密码
     * @return 返回一个字符串
     */
    public static String encryption(String pwd) {
        return PasswordEncryption.encryption(pwd, CODE_STR);
    }

    /**
     * 判断密码一致性
     *
     * @param passWord 密文
     * @param old      输入的密码
     * @param str      加密字符串 ，需要跟加密方法加密字符保持的一致
     * @return 是否一致
     */
    public static boolean decode(String passWord, String old, String str) {
        if (StringUtils.isEmpty(passWord) || StringUtils.isEmpty(old)) {
            return false;
        }
        String s = setMd5String(old, str);
        byte[] pd = Base64.getDecoder().decode(passWord);
        String pwd = new String(pd, StandardCharsets.UTF_8);

        return s.equals(pwd);
    }

    /**
     * @param args sdfdsa
     */
    public static void main(String[] args) {
        String pwd = "";
        String psw = "654321";
        String encryption1 = PasswordEncryption.encryption(psw, "sdzy");
        String encryption = PasswordEncryption.encryption(pwd);
        boolean decode = decode(null, "", "sdzy");
        System.out.println(decode);
    }
}
