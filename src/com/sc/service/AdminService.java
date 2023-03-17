package com.sc.service;

import com.sc.dao.AdminDao;
import com.sc.dao.VipCardDao;
import com.sc.po.Admin;


public class AdminService {
    VipCardDao vipCardDao = new VipCardDao();
    // 管理员登录方法判断
    // 创建AdminDao类对象
    AdminDao ad = new AdminDao();

    public Admin Login(Admin admin) {
        Admin a = ad.Login(admin);
        if (a != null) {
            return a;
        }
        return null;
    }

    public Boolean addPoints(String card, int points) {

        int i = vipCardDao.addPoints(card, points);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void allVip() {
        System.out.println(vipCardDao.selectAllVip());
    }

}
