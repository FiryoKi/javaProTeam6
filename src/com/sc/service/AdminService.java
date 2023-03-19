package com.sc.service;

import com.sc.dao.AdminDao;
import com.sc.dao.VipCardDao;
import com.sc.po.Admin;
import com.sc.po.VipCard;

import java.util.List;


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

    public List<VipCard> allVip() {
        List<VipCard> vipCards = vipCardDao.selectAllVip();
        if(vipCards.size()!=0&&vipCards!=null){
            return vipCards;
        }
        return null;
    }
    /**
     * 根据卡号查询积分
     * @param card
     * @return
     */
    public int selectPoints(String card){
        Integer i=vipCardDao.selectPointsByCard(card);
        if(i==null){
            System.out.println("该会员不存在");
            return -1;
        }else {
            return i;
        }
    }

}
