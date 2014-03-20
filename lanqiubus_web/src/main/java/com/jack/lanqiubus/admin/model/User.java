/**----------------------------------------------------------------
// Copyright (C) 2012 北京品众互动网络营销技术有限公司版权所有。
// @project：  lanqiubus_web
// @package: com.jack.lanqiubus.web.model
// @className: User
//
// @author: zhangyunjie
// @date： 2014-3-6
// @version: v1.0
//----------------------------------------------------------------*/
package com.jack.lanqiubus.admin.model;

public class User {   
    private String username;   
    private String password;   
    private String address;   
    private Integer age;   
       
    public String getUsername() {   
        return username;   
    }   
    public void setUsername(String username) {   
        this.username = username;   
    }   
    public String getPassword() {   
        return password;   
    }   
    public void setPassword(String password) {   
        this.password = password;   
    }   
    public String getAddress() {   
        return address;   
    }   
    public void setAddress(String address) {   
        this.address = address;   
    }   
    public Integer getAge() {   
        return age;   
    }   
    public void setAge(Integer age) {   
        this.age = age;   
    }   
}