package com.sc.service.impl;
import com.sc.dao.AdminDao;
import com.sc.dao.VipCardDao;
import com.sc.po.Admin;
import com.sc.po.VipCard;
import com.sc.service.AdminService;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    VipCardDao vipCardDao = new VipCardDao();
    // 管理员登录方法判断
    // 创建AdminDao类对象
    AdminDao ad = new AdminDao();
    public Admin login(Admin admin) {
        Admin a = ad.Login(admin);
        if (a != null) {
            return a;
        }
        return null;
    }

    /**
     * 开卡
     * @param vipCard
     * @return
     */
    public boolean addVipCard(VipCard vipCard) {
        int i = vipCardDao.addVipCard(vipCard);
        if(i>0) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * 查询卡号添加积分
     * @param card
     * @param points
     * @return
     */
    public Boolean addPoints(String card, int points) {

        int i = vipCardDao.addPoints(card, points);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }
    public List<VipCard> allVip() {
        ArrayList<VipCard> vipCards = vipCardDao.selectAllVip();
        if (!vipCards.isEmpty()) {
            return vipCards;
        }
        return null;
    }
    /**
     * 根据卡号查询积分
     *
     * @param card
     * @return
     */
    public int selectPoints(String card) {
        Integer i = vipCardDao.selectPointsByCard(card);
        if (i == null) {
            System.out.println("该会员不存在");
            return -1;
        } else {
            return i;
        }
    }

}
