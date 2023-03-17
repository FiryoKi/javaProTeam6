package com.sc.service;
import com.sc.dao.AdminDao;
import com.sc.po.Admin;


public class AdminService {
    //管理员登录方法判断
    //创建AdminDao类对象
    AdminDao ad = new AdminDao();
    public Admin Login(Admin admin){
        Admin a = ad.Login(admin);
        if(a!=null){
            return  a;
        }
        return null;
    }
}
