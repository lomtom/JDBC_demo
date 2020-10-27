package com.lomtom.demo.entity;

/**
 * @author: LOMTOM
 * @Date: 2020/10/27
 * @Time: 16:08
 * @Email: lomtom@qq.com
 */

public class UserEntity {

    private String UserName;

    private String Password;

    public UserEntity(String userName, String password) {
        UserName = userName;
        Password = password;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
